package ru.gbuac.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import ru.gbuac.AuthorizedUser;
import ru.gbuac.dao.*;
import ru.gbuac.model.*;
import ru.gbuac.to.*;
import ru.gbuac.util.*;
import ru.gbuac.util.exception.*;
import ru.gbuac.util.json.JsonUtil;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.gbuac.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DocServiceImpl implements DocService {

    @Autowired
    private DocRepository docRepository;

    @Autowired
    private DocValuedFieldsRepository docValuedFieldsRepository;

    @Autowired
    private DocTypeRepository docTypeRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private CatalogElemRepository catalogElemRepository;

    @Autowired
    private DocAgreementRepository docAgreementRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FieldsRolesRepository fieldsRolesRepository;

    @Autowired
    private DocNumberPrefixesRepository docNumberPrefixesRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ResolutionRepository resolutionRepository;

    @Autowired
    private ValuedFieldRepository valuedFieldRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private PublishDataService publishDataService;

    @Value("${pdf.final.dir}")
    private String pdfDir;

    @Value("${pdf.temp.dir}")
    private String pdfTempDir;

    @Value("${docx.temp.dir}")
    private String docxTempDir;

    @Value("${doc.templates.dir}")
    private String docTemplatesDir;

    @Value("${uploads.temp.dir}")
    private String uploadsTempDir;

    @Value("${uploads.dir}")
    private String uploadsDir;

    @Value("${templater.uri}")
    private String templaterUri;

    private final int DEADLINE_DAYS = 3;

    private boolean isFinalAgreementStage(int docId) {
        List<Boolean> stages = docAgreementRepository.isFinalAgreementStage(docId, PageRequest.of(0,1));
        return stages.isEmpty() ? false : stages.get(0);
    }

    @Override
    public Doc get(int id) throws NotFoundException {
        return checkNotFoundWithId(docRepository.findById(id).orElse(null), id);
    }

    @Override
    public DocTo getFullByUserName(int id, String userName) throws NotFoundException {
        DocTo docTo = asDocTo(checkNotFoundWithId(docRepository.findById(id).orElse(null), id));
        DocStatus docStatus = docTo.getDocStatus();
        if (!docStatus.equals(DocStatus.IN_AGREEMENT))  {
            docTo.setCanAgree(false);
        } else {
            boolean hasRights = docAgreementRepository.isTimeForAgreeForUser(docTo.getId(), userName).orElse(false);
            docTo.setCanAgree(hasRights || AuthorizedUser.hasRole("ADMIN"));
        }
        boolean isFinalAgreementStage = isFinalAgreementStage(id);
        if (!isFinalAgreementStage) {
            docTo.setFinalStage(false);
        } else {
            docTo.setFinalStage(true);
        }
        if (docStatus.equals(DocStatus.IN_WORK)) {
            User thisUser = userRepository.getByName(userName);

            boolean thisUserIsExecutor = docTo.getExecutorUsersIds().contains(thisUser.getId());
            docTo.setCanWork(thisUserIsExecutor || AuthorizedUser.hasRole("ADMIN"));

            boolean thisUserCanDistribute = thisUser.getDistributionDepartments().stream()
                    .anyMatch(ud -> docTo.getExecutorDepartmentsIds().contains(ud.getId()));
            docTo.setCanDistribute(thisUserCanDistribute || AuthorizedUser.hasRole("ADMIN"));
        } else {
            docTo.setCanWork(false);
        }


        return docTo;
    }

    @Override
    public List<Doc> getAllAgreementByUsername(String userName) {
        return docRepository.getAllAgreementByUserName(userName);
    }

    @Override
    public List<Doc> getAllAgreementMoreDeadlineByUserName(String userName) {
        return docRepository.getAllAgreementMoreDeadline(userName, -1, LocalDate.now().plusDays(DEADLINE_DAYS));
    }

    @Override
    public List<Doc> getAllAgreementLessDeadlineByUserName(String userName) {
        return docRepository.getAllAgreementLessDeadline(userName, -1, LocalDate.now().plusDays(DEADLINE_DAYS));
    }

    @Override
    public List<Doc> getAllAgreementMoreDeadlineByDepartment(String userName) {
        Department department = departmentRepository.getByUserName(userName).orElse(null);
        if (department != null && !department.isTopLevel()) {
            department = departmentRepository.getTopLevelForDepartment(department.getId()).orElse(null);
        }
        if (department != null) {
            List<Doc> docs =
                    docRepository.getAllAgreementMoreDeadline("", department.getId(), LocalDate.now().plusDays(DEADLINE_DAYS));
            return docs;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Doc> getAllAgreementLessDeadlineByDepartment(String userName) {
        Department department = departmentRepository.getByUserName(userName).orElse(null);
        if (department != null && !department.isTopLevel()) {
            department = departmentRepository.getTopLevelForDepartment(department.getId()).orElse(null);
        }
        if (department != null) {
            List<Doc> docs =
                    docRepository.getAllAgreementLessDeadline("", department.getId(), LocalDate.now().plusDays(DEADLINE_DAYS));
            return docs;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Doc> getAllAgreedByUsername(String userName) {
        return docRepository.getAllAgreedByUserName(userName);
    }

    @Override
    public List<Doc> getAllRegisteredByUsername(String userName) {
        return docRepository.getAllRegisteredByUserName(userName);
    }

    @Override
    public List<DocItemTo> getAll() {
        List<DocItemTo> docItemsTo = getWithUserDepsExecutors(docRepository.getAll());
        for (DocItemTo d: docItemsTo) {
            UserTo current = docAgreementRepository.getCurrentUser(d.getId());
            d.setCurrentAgreeFullName(current != null ? current.getFullName() : "");
        }
        return docItemsTo;
    }

    @Override
    public List<Doc> getAllAgreement() {
        return docRepository.getAllAgreement();
    }

    @Override
    public List<Doc> getAllRegistered() {
        return docRepository.getAllRegistered();
    }

    private List<DocItemTo> getWithUserDepsExecutors(List<Doc> docs) {
        List<DocItemTo> docItemsTo = new ArrayList<>();
        for (Doc d: docs) {
            StringBuilder deps = new StringBuilder();
            deps.append("[");
            StringBuilder users = new StringBuilder();
            users.append("[");
            for (Resolution resolution : d.getResolutions()) {
                Department department = resolution.getDepartment();
                deps.append("{\"id\":" + department.getId()+", \"name\":\""+ department.getName() + "\"},");

                for (ResolutionsUsers ru: resolution.getResolutionsUsers()) {
                    users.append("{\"id\":" + ru.getUser().getId()+", \"fullName\":\""+ ru.getUser().getLastname() + " "
                            + ru.getUser().getFirstname() + " " + ru.getUser().getPatronym() + "\"},");
                }
            }

            if (!d.getResolutions().isEmpty() && deps.charAt(deps.length()-1) == ',') {
                deps.delete(deps.length()-1, deps.length());
            }
            deps.append("]");

            if (users.length() > 1 && users.charAt(users.length()-1) == ',') {
                users.delete(users.length()-1, users.length());
            }
            users.append("]");

            LocalDate controlDate = null;
            if (!d.getResolutions().isEmpty()) {
                controlDate = Optional.ofNullable(d.getResolutions())
                        .map(Collection::stream).orElseGet(Stream::empty).filter(r -> r.isPrimaryResolution())
                        .map(r -> Optional.ofNullable(r.getControlDate())).findFirst().orElse(null).orElse(null);
            }
            boolean isAlarmControlDate = false;
            if (controlDate != null) {
                isAlarmControlDate = controlDate.isBefore(LocalDate.now().plusDays(DEADLINE_DAYS+1)) &&
                        d.getDocStatus() != DocStatus.COMPLETED;
            }
            docItemsTo.add(new DocItemTo(d.getId(), d.getDocStatus(), d.getRegNum(), d.getRegDateTime(),
                    d.getProjectRegNum(), d.getProjectRegDateTime(), controlDate, isAlarmControlDate, deps.toString(),
                    users.toString(), d.getDocType().getName()));
        }
        return docItemsTo;
    }

    @Override
    public List<DocItemTo> getAllInWorkByUserName(String userName) {
        List<Doc> docs = docRepository.getAllInWorkByUserName(userName);
        return getWithUserDepsExecutors(docs);
    }

    @Override
    public List<DocItemTo> getAllInWorkMoreDeadlineByUserName(String userName) {
        departmentRepository.getByUserName(userName);
        List<Doc> docs = docRepository.getAllInWorkMoreDeadline(userName, -1, LocalDate.now().plusDays(DEADLINE_DAYS));
        return getWithUserDepsExecutors(docs);
    }

    @Override
    public List<DocItemTo> getAllInWorkLessDeadlineByUserName(String userName) {
        List<Doc> docs = docRepository.getAllInWorkLessDeadline(userName, -1, LocalDate.now().plusDays(DEADLINE_DAYS));
        return getWithUserDepsExecutors(docs);
    }

    @Override
    public List<DocItemTo> getAllInWorkMoreDeadlineByDepartment(String userName) {
        Department department = departmentRepository.getByUserName(userName).orElse(null);
        if (department != null && !department.isTopLevel()) {
            department = departmentRepository.getTopLevelForDepartment(department.getId()).orElse(null);
        }
        if (department != null) {
            List<Doc> docs =
                    docRepository.getAllInWorkMoreDeadline("", department.getId(), LocalDate.now().plusDays(DEADLINE_DAYS));
            return getWithUserDepsExecutors(docs);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<DocItemTo> getAllInWorkLessDeadlineByDepartment(String userName) {
        Department department = departmentRepository.getByUserName(userName).orElse(null);
        if (department != null && !department.isTopLevel()) {
            department = departmentRepository.getTopLevelForDepartment(department.getId()).orElse(null);
        }
        if (department != null) {
            List<Doc> docs =
                    docRepository.getAllInWorkLessDeadline("", department.getId(), LocalDate.now().plusDays(DEADLINE_DAYS));
            return getWithUserDepsExecutors(docs);
        } else {
            return Collections.emptyList();
        }
    }

    private List<Department> getUserDistributionDepartments(String userName) {
        User curUser = userRepository.getByName(userName);
        return curUser.getDistributionDepartments();
    }

    @Override
    public List<DocItemTo> getAllDistribution(String userName) {
        List<Doc> docs = new ArrayList<>();
        Optional.ofNullable(getUserDistributionDepartments(userName)).map(Collection::stream).orElseGet(Stream::empty)
                .forEach(d -> docs.addAll(docRepository.getAllDistribution(d.getId())));
        return getWithUserDepsExecutors(docs);
    }

    @Override
    public List<DocItemTo> getAllDistributionMoreDeadlineByChiefUserName(String userName) {
        List<Doc> docs = new ArrayList<>();
        Optional.ofNullable(getUserDistributionDepartments(userName)).map(Collection::stream).orElseGet(Stream::empty)
                .forEach(d -> docs.addAll(docRepository.getAllDistributionMoreDeadline(d.getId(), LocalDate.now().plusDays(DEADLINE_DAYS))));
        return getWithUserDepsExecutors(docs);
    }

    @Override
    public List<DocItemTo> getAllDistributionLessDeadlineByChiefUserName(String userName) {
        List<Doc> docs = new ArrayList<>();
        Optional.ofNullable(getUserDistributionDepartments(userName)).map(Collection::stream).orElseGet(Stream::empty)
                .forEach(d -> docs.addAll(docRepository.getAllDistributionLessDeadline(d.getId(), LocalDate.now().plusDays(DEADLINE_DAYS))));
        return getWithUserDepsExecutors(docs);
    }

    @Override
    public List<DocItemTo> getAllDistributionMoreDeadlineByDepartment(String userName) {
        Department department = departmentRepository.getByUserName(userName).orElse(null);
        if (department != null && !department.isTopLevel()) {
            department = departmentRepository.getTopLevelForDepartment(department.getId()).orElse(null);
        }
        if (department != null) {
            List<Doc> docs = docRepository.getAllDistributionMoreDeadline(department.getId(), LocalDate.now().plusDays(DEADLINE_DAYS));
            return getWithUserDepsExecutors(docs);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<DocItemTo> getAllDistributionLessDeadlineByDepartment(String userName) {
        Department department = departmentRepository.getByUserName(userName).orElse(null);
        if (department != null && !department.isTopLevel()) {
            department = departmentRepository.getTopLevelForDepartment(department.getId()).orElse(null);
        }
        if (department != null) {
            List<Doc> docs = docRepository.getAllDistributionLessDeadline(department.getId(), LocalDate.now().plusDays(DEADLINE_DAYS));
            return getWithUserDepsExecutors(docs);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<DocItemTo> getAllDistributed(String userName) {
        List<Doc> docs = new ArrayList<>();
        Optional.ofNullable(getUserDistributionDepartments(userName)).map(Collection::stream).orElseGet(Stream::empty)
                .forEach(d -> docs.addAll(docRepository.getAllDistributed(d.getId())));
        return getWithUserDepsExecutors(docs);
    }

    @Override
    public List<DocItemTo> getAllAtThisMounthOnControl(String userName) {
        List<Doc> docs = docRepository.getAllAtThisMounthOnControl(userName, LocalDate.now(), LocalDate.now().minusMonths(1));
        return getWithUserDepsExecutors(docs);
    }

    @Override
    public List<DocItemTo> getAllAtThisMounthOnControlCompletedInTime(String userName) {
        List<Doc> docs =  docRepository.getAllAtThisMounthOnControlCompletedInTime(userName, LocalDate.now(), LocalDate.now().minusMonths(1));
        return getWithUserDepsExecutors(docs);
    }

    @Override
    public List<DocItemTo> getAllAtThisMounthOnControlCompletedAfterTime(String userName) {
        List<Doc> docs =  docRepository.getAllAtThisMounthOnControlCompletedAfterTime(userName, LocalDate.now(), LocalDate.now().minusMonths(1));
        return getWithUserDepsExecutors(docs);
    }

    @Override
    public List<DocItemTo> getAllAtThisMounthOnControlNotCompleted(String userName) {
        List<Doc> docs =  docRepository.getAllAtThisMounthOnControlNotCompleted(userName, LocalDate.now());
        return getWithUserDepsExecutors(docs);
    }

    @Override
    public List<DocNumberTo> getRegNumbers() {
        return docRepository.getRegNumbers();
    }

    @Override
    public DocTo save(DocTo docTo, String userName, String rootPath) throws UnauthorizedUserException {
        Assert.notNull(docTo, "doc must not be null");

        DocType docType = docTypeRepository.findById(docTo.getDocTypeId()).orElse(null);
        if (!docType.isFinalDoc()) {
            if (docTo.getExecutorDepartmentsIds() == null || docTo.getExecutorDepartmentsIds().isEmpty()) {
                throw new EmptyToException();
            }
        }

        Integer finalUserId = docTo.getFinalUserId();
        boolean hasRights = AuthorizedUser.hasRole(docType.getRole().getAuthority());
        if (!hasRights && !AuthorizedUser.hasRole("ADMIN")) {
            throw new UnauthorizedUserException();
        }

        docTo.setProjectRegNum(docNumberPrefixesRepository.generateDocNumber("согл", ""));
        Doc docToSave = createNewDocFromTo(docTo);
        docToSave.setInitialUser(userRepository.getByName(userName));

        Doc saved = docRepository.save(docToSave);
        DocTo savedTo = asDocTo(saved);
        savedTo.setFinalUserId(finalUserId);
        String urlPdf = createPDFOrDocx(savedTo, rootPath, false, true);
        docRepository.setUrlPDF(savedTo.getId(), urlPdf);
        savedTo.setUrlPDF(urlPdf);
        savedTo.setCanAgree(hasRights || AuthorizedUser.hasRole("ADMIN"));
        return savedTo;
    }

    @Override
    public DocTo update(DocTo docTo, int id, String userName, String rootPath, boolean delegatedRights) throws NotFoundException, UnauthorizedUserException {
        String comment = docTo.getComment();
        Assert.notNull(docTo, "docTo must not be null");

        Doc updated = docFromTo(docTo);
        boolean isFinalAgreementStage = isFinalAgreementStage(id);

        if (isFinalAgreementStage) {
            String docTypeMask = docNumberPrefixesRepository.getMaskByDocTypeId(docTo.getDocTypeId());
            String docNumber = "";
            if (docTo.getDocTypeId() == 2) {
                List<Doc> docs = docRepository.getAllByDocType(docTo.getDocTypeId());
                StringBuilder optional = new StringBuilder();
                for (DocValuedFields docValuedFields : updated.getDocValuedFields()) {
                    if (docValuedFields.getValuedField().getField().getId() == 4) {
                        LocalDate agendaDate = docValuedFields.getValuedField().getValueDate().toLocalDate();
                        optional.append(agendaDate.format(DateTimeFormatter.ofPattern("dd.MM")));
                        long agendaCountForDay = docs.stream()
                                .filter(f -> f.getDocType().getId() == 2)
                                .filter(f -> f.getDocStatus() == DocStatus.IN_WORK || f.getDocStatus() == DocStatus.COMPLETED)
                                .flatMap(f -> f.getDocValuedFields().stream())
                                .filter(f -> f.getValuedField().getField().getId() == 4)
                                .filter(f -> f.getValuedField().getValueDate().toLocalDate().equals(agendaDate))
                                .count();
                        optional.append("-");
                        agendaCountForDay++;
                        optional.append(agendaCountForDay);
                        break;
                    }
                }
                docNumber = docNumberPrefixesRepository.generateDocNumber(docTypeMask, optional.toString());
            } else {
                docNumber = docNumberPrefixesRepository.generateDocNumber(docTypeMask, "");
            }
            updated.setRegNum(docNumber);
            updated.setRegDateTime(LocalDateTime.now());
            updated.setDocStatus(DocStatus.IN_WORK);
            //resolutionRepository
            //        .setControlDateForPrimaryResolution(updated.getId(), LocalDateTime.now().plusDays(2).toLocalDate());
        }

        boolean hasRights = docAgreementRepository.isTimeForAgreeForUser(docTo.getId(), userName).orElse(false);

        if (!hasRights && !AuthorizedUser.hasRole("ADMIN")) {
            throw new UnauthorizedUserException();
        }

        // Генерация проектного PDF с добавлением ссылки в сущность, либо если isFinalStage, то
        // перемещаем файл из временного хранилища temp_uploads в хранилище pdf
        updated.setUrlPDF(createPDFOrDocx(asDocTo(updated), rootPath, false, true));
        List<DocValuedFields> docValuedFields = docValuedFieldsRepository.getAll(id);
        for (DocValuedFields df: docValuedFields) {
            recursiveDeleteFields(df.getValuedField());
        }
        docValuedFieldsRepository.deleteAll(id);

        List<DocAgreement> docAgreementList = docAgreementRepository.getAll(updated.getId());
        DocAgreement daCurrent = docAgreementList.stream().filter(DocAgreement::isCurrentUser).findFirst().orElse(null);
        if (daCurrent != null) {
            daCurrent.setComment(comment);
            daCurrent.setDecisionType(DecisionType.ACCEPTED);
            daCurrent.setAgreedDateTime(LocalDateTime.now());
            daCurrent.setCurrentUser(false);
            if(delegatedRights) {
                daCurrent.setOriginUser(userRepository.getByName(AuthorizedUser.getUserName()));
            }
            docAgreementRepository.save(daCurrent);
            if (!isFinalAgreementStage) {
                DocAgreement daNext = docAgreementRepository.getByOrder(docTo.getId(), daCurrent.getOrdering() + 1);
                daNext.setCurrentUser(true);
                docAgreementRepository.save(daNext);
                User user = userRepository.findById(daNext.getUser().getId()).orElse(null);
                mailService.sendAgreementEmail(user.getEmail(), docTo.getId(), updated.getProjectRegNum());
            }
        }
        updated = checkNotFoundWithId(docRepository.save(updated), id);
        if (isFinalAgreementStage) {
            if (updated.getParentDoc() != null) {
                resolutionRepository.setExecutionDateTimeForDoc(updated.getParentDoc().getId(), LocalDateTime.now());
                docRepository.setDocStatusByDocId(updated.getParentDoc().getId(), DocStatus.COMPLETED);
            }
            User initialUser = updated.getInitialUser();
            mailService.sendRegisteredEmail(initialUser.getEmail(), updated.getId(), updated.getProjectRegNum(),
                    updated.getRegNum());
            try {
                User finalUser = userRepository.findById(docTo.getFinalUserId()).orElse(null);
                byte[] fileBytes = IOUtils.toByteArray(new FileInputStream(rootPath + updated.getUrlPDF()));
                publishDataService.publish(updated, fileBytes, finalUser);
            }
            catch (Exception ignored) {

            }
        }
        DocTo updatedTo = asDocTo(updated);
        updatedTo.setCanAgree(hasRights || AuthorizedUser.hasRole("ADMIN"));
        if (updated.getDocStatus() == DocStatus.IN_WORK) {
            for (Resolution resolution : updated.getResolutions()) {
                mailService.sendDistributionEmail(resolution.getDepartment().getChiefUser().getEmail(),
                        updated.getId(), updated.getRegNum());
            }
        }
        return asDocTo(updated);
    }

    private void recursiveDeleteFields(ValuedField valuedField) {
        for (ValuedField child: valuedField.getChildValuedField()) {
            recursiveDeleteFields(child);
            valuedFieldRepository.delete(child.getId());
        }
        valuedFieldRepository.delete(valuedField.getId());
    }

    public static void moveFile(String oldPath, String newPath) {
        new File(newPath).delete();
        File oldFile = new File(oldPath);
        oldFile.renameTo(new File(newPath));
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Assert.notNull(id, "doc must not be null");
        checkNotFoundWithId(docRepository.delete(id)!= 0, id);
    }

    @Override
    public DocTo rejectDocAgreement(int id, String userName, String comment) throws NotFoundException {
        Doc updated = checkNotFoundWithId(docRepository.findById(id).orElse(null), id);
        updated.setDocStatus(DocStatus.AGREEMENT_REJECTED);
        docRepository.save(updated);
        List<DocAgreement> docAgreementList = docAgreementRepository.getAll(id);
        DocAgreement daCurrent = docAgreementList.stream().filter(DocAgreement::isCurrentUser).findFirst().orElse(null);
        daCurrent.setAgreedDateTime(LocalDateTime.now());
        daCurrent.setComment(comment);
        daCurrent.setDecisionType(DecisionType.REJECTED);
        docAgreementRepository.save(daCurrent);
        return asDocTo(checkNotFoundWithId(docRepository.save(updated), id));
    }


    private int countUniqueCellTags(Map<String, String> cellTags) {
        int count = 0;
        for (Map.Entry<String, String> entry : cellTags.entrySet()) {
            if (!entry.getKey().contains(".")) {
                count++;
            }
        }
        return count;
    }

    private void fillTags(FieldTo fieldTo, Map<String, String> simpleTags, Map<String, TaggedTable> taggedTables, Map<String, String> htmlTables, Integer maxCellsCount) {
        String tag = fieldTo.getTag();
        if (TagUtil.getTableTag(tag) != null) {
            Map<String, String> cellsTags;
            String tableTag = TagUtil.getTableTag(tag);
            if (!taggedTables.containsKey(tableTag)) {
                cellsTags = new HashMap<>();
                taggedTables.put(tableTag, new TaggedTable(tableTag, new ArrayList<TableRow>() {{
                    add(new TableRow(cellsTags));}}));
            } else {
                List<TableRow> rows = taggedTables.get(tableTag).getRows();
                if (countUniqueCellTags(rows.get(rows.size()-1).getCellsTags()) == maxCellsCount) {
                    cellsTags = new HashMap<>();
                    rows.add((new TableRow(cellsTags)));
                }
                else
                {
                    cellsTags = rows.get(rows.size()-1).getCellsTags();
                }
            }
            switch (fieldTo.getFieldType()) {
                case GROUP_FIELDS:
                    cellsTags.put(tag, fieldTo.getValueByFieldType());
                    for (FieldTo childField : fieldTo.getChildFields()) {
                        childField.setTag("[" + fieldTo.getTag() + "]" + childField.getTag());
                        fillTags(childField, simpleTags, taggedTables, htmlTables, fieldTo.getChildFields().size());
                    }
                case GROUP_CHECKBOX:
                    cellsTags.put(tag, fieldTo.getValueByFieldType());
                    for (FieldTo childField : fieldTo.getChildFields()) {
                        if (TagUtil.getTableTag(tag) != null) {
                            childField.setTag(fieldTo.getTag() + "." + childField.getTag());
                        }
                        fillTags(childField, simpleTags, taggedTables, htmlTables, fieldTo.getChildFields().size());
                    }
                    break;
                case CATALOG:
                    if (fieldTo.getValueInt() == null) {
                        cellsTags.put(tag, "");
                        break;
                    }
                    CatalogElem catalogElemChild = catalogElemRepository.findById(fieldTo.getValueInt()).orElse(null);
                        switch (catalogElemChild.getCatalog().getCatalogType()) {
                            case TEXT:
                                cellsTags.put(tag, catalogElemChild.getValueStr());
                                cellsTags.put(tag + ".Preposition", catalogElemChild.getValueStrPreposition());
                                break;
                            case NUMBER:
                                cellsTags.put(tag, catalogElemChild.getValueInt());
                                break;
                        }
                    break;
                case CATALOG_USERS:
                    if (fieldTo.getValueInt() == null) {
                        cellsTags.put(tag, "");
                        break;
                    }
                    User user = userRepository.findById(fieldTo.getValueInt()).orElse(null);

                    cellsTags.put(tag, user.getFirstname().substring(0,1) + "." + user.getPatronym().substring(0,1) + ". " + user.getLastname());
                    cellsTags.put(tag + ".Firstname", user.getFirstname());
                    cellsTags.put(tag + ".Patronym", user.getPatronym());
                    cellsTags.put(tag + ".Lastname", user.getLastname());
                    cellsTags.put(tag + ".Fullname", user.getFirstname() + " " + user.getPatronym() + " " + user.getLastname());
                    cellsTags.put(tag + ".Phone", user.getPhone());
                    break;
                case CATALOG_ORGANIZATIONS:
                    if (fieldTo.getValueInt() == null) {
                        cellsTags.put(tag, "");
                        break;
                    }
                    Organization organization = organizationRepository.findById(fieldTo.getValueInt()).orElse(null);
                    cellsTags.put(tag, organization.getShortNameLf());
                    break;
                case CATALOG_REGNUMBERS:
                    if (fieldTo.getValueInt() == null) {
                        cellsTags.put(tag, "");
                        break;
                    }
                    String regNum = docRepository.findById(fieldTo.getValueInt()).orElse(null).getRegNum();
                    cellsTags.put(tag, regNum);
                    break;
                case DATE:
                    if (!tag.equals("")) {
                        cellsTags.put(tag + ".dd.MM.yyyy", fieldTo.getValueDate() != null ? DateTimeUtil.toString(fieldTo.getValueDate().toLocalDate()) : "");
                        cellsTags.put(tag + ".dd MMMM yyyy", fieldTo.getValueDate() != null ? DateTimeUtil.toStringPrint(fieldTo.getValueDate().toLocalDate()) : "");
                    }
                    break;
                default:
                    if (!tag.equals("")) {
                        cellsTags.put(tag, fieldTo.getValueByFieldType());
                    }
                    break;
            }
        } else
        if (TagUtil.getSimpleTag(tag) != null) {
            switch (fieldTo.getFieldType()) {
                case GROUP_CHECKBOX:
                    simpleTags.put(tag, fieldTo.getValueByFieldType());
                    for (FieldTo childField : fieldTo.getChildFields()) {
                        int childMaxCellsCount = (int) fieldTo.getChildFields().stream()
                                .filter(c -> !c.getTag().equals("")).count();
                        fillTags(childField, simpleTags, taggedTables, htmlTables, childMaxCellsCount);
                    }
                    break;
                case GROUP_FIELDS:
                    simpleTags.put(tag, fieldTo.getValueByFieldType());
                    for (FieldTo childField : fieldTo.getChildFields()) {
                        childField.setTag("[" + fieldTo.getTag() + "]" + childField.getTag());
                        int childMaxCellsCount = (int) fieldTo.getChildFields().stream()
                                .filter(c -> !c.getTag().equals("")).count();
                        fillTags(childField, simpleTags, taggedTables, htmlTables, childMaxCellsCount);
                    }
                    break;
                case CATALOG:
                    if (fieldTo.getValueInt() == null) {
                        simpleTags.put(tag, "");
                        break;
                    }
                    CatalogElem catalogElemChild =
                            catalogElemRepository.findById(fieldTo.getValueInt()).orElse(null);
                    switch (catalogElemChild.getCatalog().getCatalogType()) {
                        case TEXT:
                            simpleTags.put(tag, catalogElemChild.getValueStr());
                            simpleTags.put(tag + ".Preposition", catalogElemChild.getValueStrPreposition());
                            break;
                        case NUMBER:
                            simpleTags.put(tag, catalogElemChild.getValueInt());
                            break;
                    }
                    break;
                case CATALOG_USERS:
                    if (fieldTo.getValueInt() == null) {
                        simpleTags.put(tag, "");
                        break;
                    }
                    User user = userRepository.findById(fieldTo.getValueInt()).orElse(null);
                    simpleTags.put(tag, user.getFirstname().substring(0,1) + "." + user.getPatronym().substring(0,1) + ". " + user.getLastname());
                    simpleTags.put(tag + ".Firstname", user.getFirstname());
                    simpleTags.put(tag + ".Patronym", user.getPatronym());
                    simpleTags.put(tag + ".Lastname", user.getLastname());
                    simpleTags.put(tag + ".Fullname", user.getFirstname() + " " + user.getPatronym() + " " + user.getLastname());
                    simpleTags.put(tag + ".Phone", user.getPhone());
                    break;
                case CATALOG_ORGANIZATIONS:
                    if (fieldTo.getValueInt() == null) {
                        simpleTags.put(tag, "");
                        break;
                    }
                    Organization organization = organizationRepository.findById(fieldTo.getValueInt()).orElse(null);
                    simpleTags.put(tag, organization.getShortNameLf());
                    break;
                case CATALOG_REGNUMBERS:
                    if (fieldTo.getValueInt() == null) {
                        simpleTags.put(tag, "");
                        break;
                    }
                    String regNum = docRepository.findById(fieldTo.getValueInt()).orElse(null).getRegNum();
                    simpleTags.put(tag, regNum);
                    break;
                case DATE:
                    if (!tag.equals("")) {
                        simpleTags.put(tag + ".dd.MM.yyyy", fieldTo.getValueDate() != null ? DateTimeUtil.toString(fieldTo.getValueDate().toLocalDate()) : "");
                        simpleTags.put(tag + ".dd MMMM yyyy", fieldTo.getValueDate() != null ? DateTimeUtil.toStringPrint(fieldTo.getValueDate().toLocalDate()) : "");
                    }
                    break;
                case CATALOG_HTML_TABLES:
                    if (!tag.equals("")) {
                        htmlTables.put(tag, fieldTo.getValueByFieldType());
                    }
                default:
                    if (!tag.equals("")) {
                        simpleTags.put(tag, fieldTo.getValueByFieldType());
                    }
                    break;
            }
        }
    }

    @Override
    public FileTo uploadFile(MultipartFile inputFile, String rootPath) throws FileUploadException {
        String savePath = rootPath + uploadsTempDir + UUID.randomUUID().toString() + "_" + inputFile.getOriginalFilename();
        try {
            inputFile.transferTo(new File(savePath));
        }
         catch (IOException e) {
            throw new FileUploadException();
        }
        return new FileTo(savePath);
    }

    @Override
    public FileTo createDOCX(DocTo docTo, String rootPath) {
        Integer finalUserId = docTo.getFinalUserId();
        DocTo docToFull = asDocTo(createNewDocFromTo(docTo));
        docToFull.setFinalUserId(finalUserId);
        return new FileTo(createPDFOrDocx(docToFull, rootPath,  true, false));
    }

    @Override
    public FileTo createPDF(DocTo docTo, String rootPath) {
        Integer finalUserId = docTo.getFinalUserId();
        DocTo docToFull = asDocTo(createNewDocFromTo(docTo));
        docToFull.setFinalUserId(finalUserId);
        return new FileTo(createPDFOrDocx(docToFull, rootPath,  true, true));
    }

    private String createPDFOrDocx(DocTo docTo, String rootPath, Boolean saveToTempDir, Boolean isPDF) {
        DocType docType = docTypeRepository.findById(docTo.getDocTypeId()).orElse(null);
        String docTemplatePath = rootPath + docTemplatesDir + docType.getTemplateFileName();
        String docAppendixTemplatePath = rootPath + docTemplatesDir + docType.getAppendixTemplateFileName();

        String pdfTempPath = rootPath + pdfTempDir + UUID.randomUUID().toString() + ".pdf";
        String pdfPath = rootPath + pdfDir + docTo.getId() + ".pdf";

        String pdfSavePath = saveToTempDir ? pdfTempPath : pdfPath;
        String docxSavePath = rootPath + docxTempDir + UUID.randomUUID().toString() + ".docx";

        String savePath = isPDF ? pdfSavePath : docxSavePath;

        Map<String, String> simpleTags = new HashMap<>();
        simpleTags.put("RegNum", Optional.ofNullable(docTo.getRegNum() != null ? docTo.getRegNum() : docTo.getProjectRegNum()).orElse(""));
        LocalDate regDate = docTo.getRegDateTime() != null ? docTo.getRegDateTime().toLocalDate() : null;
        if (regDate == null) {
            regDate = docTo.getProjectRegDateTime() != null ? docTo.getProjectRegDateTime().toLocalDate() : null;
        }
        simpleTags.put("RegDate.dd.MM.yyyy", regDate != null ? DateTimeUtil.toString(regDate) : "");
        simpleTags.put("RegDate.dd MMMM yyyy", regDate != null ? DateTimeUtil.toStringPrint(regDate) : "");

        if (docTo.getFinalUserId() != null) {
            User finalUser = userRepository.findById(docTo.getFinalUserId()).orElse(null);
            if (finalUser != null) {
                simpleTags.put("SignerPosition", finalUser.getShortPosition());
                simpleTags.put("SignerFullPosition", finalUser.getFullPosition());
                simpleTags.put("Signer", finalUser.getFirstname().substring(0, 1) + "." + finalUser.getPatronym().substring(0, 1)
                        + "." + finalUser.getLastname());
                simpleTags.put("Department", finalUser.getDepartment() != null ? finalUser.getDepartment().getName() : "");
            }
        }


        if (docTo.getExecutorDepartmentsIds() != null && !docTo.getExecutorDepartmentsIds().isEmpty()) {
            for (int i = 0; i < docTo.getExecutorDepartmentsIds().size(); i++) {
                Department exDep = departmentRepository.findById(docTo.getExecutorDepartmentsIds().get(i)).orElse(null);
                List<FieldTo> exDepsFields = new ArrayList<>();
                exDepsFields.add(new FieldTo(null, FieldType.TEXT, exDep.getChiefUser().getDativePosition(), "Department"));
                exDepsFields.add(new FieldTo(null, FieldType.TEXT, exDep.getChiefUser().getDativeFullname(), "Chief"));
                docTo.getChildFields().add(new DocFieldsTo(null, new FieldTo(exDepsFields, FieldType.GROUP_FIELDS, "To"), null));
            }
        } else {
            List<FieldTo> exDepsFields = new ArrayList<>();
            exDepsFields.add(new FieldTo(null, FieldType.TEXT, "", "Department"));
            exDepsFields.add(new FieldTo(null, FieldType.TEXT, "", "Chief"));
            docTo.getChildFields().add(new DocFieldsTo(null, new FieldTo(exDepsFields, FieldType.GROUP_FIELDS, "To"), null));
        }

        Map<String, TaggedTable> taggedTables = new HashMap<>();
        Map<String, String> htmlTables = new HashMap<>();
        for (DocFieldsTo docFieldsTo : docTo.getChildFields()) {
            if (docFieldsTo.getField().getAppendix() == null || !docFieldsTo.getField().getAppendix()) {
                fillTags(docFieldsTo.getField(), simpleTags, taggedTables, htmlTables, docTo.getChildFields().size());
            }
        }

        try {
            String JSONString = JsonUtil.writeValue(new TemplateDataTo(IOUtils.toByteArray(new FileInputStream(docTemplatePath)),
                    simpleTags, taggedTables, htmlTables, isPDF));

            PDFMergerUtility ut = new PDFMergerUtility();
            ut.addSource(new ByteArrayInputStream(getDocFromItGeoService(JSONString)));
            int appedixNumber = 0;
            for (DocFieldsTo docFieldsTo : docTo.getChildFields()) {
                if (docFieldsTo.getField().getFieldType() == FieldType.GROUP_FIELDS && docFieldsTo.getField().getAppendix() != null && docFieldsTo.getField().getAppendix()) {
                    FieldTo appendixGroupField = docFieldsTo.getField();
                    simpleTags.put("AppendN", String.valueOf(++appedixNumber));
                    for (FieldTo appField : appendixGroupField.getChildFields()) {
                        fillTags(appField, simpleTags, taggedTables, htmlTables, docTo.getChildFields().size());
                    }
                    JSONString = JsonUtil.writeValue(new TemplateDataTo(IOUtils.toByteArray(new FileInputStream(docAppendixTemplatePath)),
                            simpleTags, taggedTables, htmlTables, isPDF));
                    ut.addSource(new ByteArrayInputStream(getDocFromItGeoService(JSONString)));
                }
            }
            ut.setDestinationFileName(savePath);
            ut.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        } catch (Exception e) {
            throw new GeneratePdfException();
        }

        return savePath.replace(rootPath,"");
    }

    private byte[] getDocFromItGeoService(String JSONString) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(templaterUri);
        StringEntity params = new StringEntity(JSONString, "UTF-8");
        params.setContentEncoding("UTF-8");
        params.setContentType("application/json");
        String userCredentials = "admin:admin";
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
        request.addHeader("Authorization", basicAuth);
        request.setEntity(params);
        HttpResponse response = httpClient.execute(request);
        return EntityUtils.toByteArray(response.getEntity());
    }

    private DocTo asDocTo(Doc doc) {
        Integer docTypeId = doc.getDocType().getId();
        List<String> curUserRoles = AuthorizedUser.getRoles();

        List<DocValuedFields> docValuedFields = doc.getDocValuedFields();
        List<DocFieldsTo> docFieldsTos = new ArrayList<>();
        List<FieldsRoles> fieldsRoles = fieldsRolesRepository.getAll(docTypeId);
        Map<Integer, FieldsRoles> fMap = fieldsRoles.stream()
                .collect(Collectors.toMap(FieldsRoles::getFieldId, f -> f));

        boolean deny = false;
        boolean canAgree = false;
        if (doc.getId() != null) {
            canAgree = docAgreementRepository.isTimeForAgreeForUser(doc.getId(), AuthorizedUser.getUserName())
                    .orElse(false);
        }
        if (doc.getDocStatus() == DocStatus.IN_WORK || (!canAgree && !AuthorizedUser.hasRole("ADMIN"))) {
            deny = true;
        }


        boolean isFinalAgreementStage = false;
        if (doc.getId() != null) {
            isFinalAgreementStage = isFinalAgreementStage(doc.getId());
        }

        for (DocValuedFields d:docValuedFields) {
            docFieldsTos.add(new DocFieldsTo(d.getId(),
                    FieldUtil.asTo(d.getValuedField(), curUserRoles, (HashMap<Integer, FieldsRoles>) fMap, deny, false), d.getPosition()));
        }

        List<Integer> executorDepartmentsIds = null;
        List<Integer> executorUsersIds = null;
        if (doc.getResolutions() != null) {
            executorDepartmentsIds = doc.getResolutions().stream()
                    .sorted(Comparator.comparing(Resolution::getOrdering))
                    .map(Resolution::getDepartment)
                    .map(Department::getId)
                    .collect(Collectors.toList());
            executorUsersIds = doc.getResolutions()
                    .stream().flatMap(r -> Optional.ofNullable(r.getResolutionsUsers()).map(Collection::stream).orElseGet(Stream::empty))
                        .map(r -> r.getUser().getId()).collect(Collectors.toList());
        }

        User initialUser = doc.getInitialUser();
        UserTo initialUserTo = null;
        if (initialUser != null) {
            initialUserTo = new UserTo(initialUser.getId(), initialUser.getLastname() + " "
                    + initialUser.getFirstname() + " " + initialUser.getPatronym(), initialUser.getPhone(),
                    initialUser.getPosition());
        }


        Integer finalUserId = null;
        if (doc.getId() != null) {
            User finalUser = docAgreementRepository.getFinalUser(doc.getId());
            if (finalUser != null) {
                finalUserId = finalUser.getId();
            }
        }

        return new DocTo(doc.getId(), doc.getRegNum(), doc.getRegDateTime(), doc.getProjectRegNum(),
                doc.getProjectRegDateTime(), doc.getInsertDateTime(), doc.getDocType().getId(),
                doc.getDocStatus(), isFinalAgreementStage, false, false, false, doc.getUrlPDF(),
                initialUserTo, finalUserId, doc.getDocType().isFinalDoc(), null, executorDepartmentsIds,
                executorUsersIds, docFieldsTos, doc.getParentDoc() != null ? doc.getParentDoc().getId(): null);
    }

    public ValuedField createNewValueFieldFromTo(FieldTo newField) {
        List<ValuedField> childFields = new ArrayList<>();
        for (FieldTo childFieldTo : newField.getChildFields()) {
            childFields.add(createNewValueFieldFromTo(childFieldTo));
        }

        Field field = fieldRepository.findById(newField.getFieldId()).orElse(null);
        CatalogElem catalogElem = null;
        if (field.getFieldType() == FieldType.CATALOG) {
            if (newField.getValueInt() != null) {
                catalogElem = catalogElemRepository.findById(newField.getValueInt()).orElse(null);
                newField.setValueInt(null);
            }
        }

        return new ValuedField(null, childFields,  field, catalogElem, newField.getValueInt(), newField.getValueStr(),
                newField.getValueDate(), newField.getValueDate(), newField.getValueDate());
    }

    private Doc createNewDocFromTo(DocTo docTo) {
        DocType docType = docTypeRepository.findById(docTo.getDocTypeId()).orElse(null);
        Doc parentDoc = null;
        if (docTo.getParentDocId() != null) {
            parentDoc = docRepository.findById(docTo.getParentDocId()).orElse(null);
        }

        Doc doc = new Doc(null, docTo.getRegNum(), docTo.getRegDateTime(), docTo.getProjectRegNum(),
                docTo.getProjectRegDateTime(), docTo.getInsertDateTime(), docType, null,
                null, null, docTo.getUrlPDF(), parentDoc);

        List<Department> executorDepartments = Optional.ofNullable(docTo.getExecutorDepartmentsIds())
                .map(Collection::stream).orElseGet(Stream::empty)
                .map(d -> departmentRepository.findById(d).orElse(null))
                .filter(Objects::nonNull).collect(Collectors.toList());

        List<Resolution> resolutions = new ArrayList<>();
        for (int i = 0; i < executorDepartments.size(); i++) {
            resolutions
                    .add(new Resolution(null, i+1, doc, i==0, executorDepartments.get(i)));
        }

        doc.setResolutions(resolutions);
        doc.setDocValuedFields(createNewValuedFieldsByDoc(doc, docTo.getChildFields()));
        return doc;
    }

    private Doc docFromTo(DocTo docTo) {
        DocType docType = docTypeRepository.findById(docTo.getDocTypeId()).orElse(null);
        Doc exDoc = checkNotFoundWithId(docRepository.findById(docTo.getId()).orElse(null), docTo.getId());
        Doc doc = new Doc(exDoc.getId(), exDoc.getRegNum(), exDoc.getRegDateTime(), exDoc.getProjectRegNum(),
                exDoc.getProjectRegDateTime(), exDoc.getInsertDateTime(), docType, exDoc.getResolutions(),
                null, exDoc.getInitialUser(), exDoc.getUrlPDF(), exDoc.getParentDoc());

        doc.setDocValuedFields(createNewValuedFieldsByDoc(doc, docTo.getChildFields()));

        return doc;
    }

    private List<DocValuedFields> createNewValuedFieldsByDoc(Doc doc, List<DocFieldsTo> docFieldsTos) {
        List<DocValuedFields> docValuedFields = new ArrayList<>();
        for (DocFieldsTo d:docFieldsTos) {
            docValuedFields.add(new DocValuedFields(null, doc,
                    createNewValueFieldFromTo(d.getField()), d.getPosition()));
        }
        return docValuedFields;
    }
}
