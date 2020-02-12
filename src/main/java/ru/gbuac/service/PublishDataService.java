package ru.gbuac.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.gbuac.dao.CatalogElemRepository;
import ru.gbuac.dao.CatalogRepository;
import ru.gbuac.dao.OrganizationRepository;
import ru.gbuac.dao.PublishDataRepository;
import ru.gbuac.jaxws.basereg.CreateDocumentFile;
import ru.gbuac.jaxws.basereg.DocStatus;
import ru.gbuac.jaxws.basereg.ResponseStatus;
import ru.gbuac.model.*;
import ru.gbuac.util.DateTimeUtil;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PublishDataService {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    public JavaMailSender emailSender;

    @Value("${email.sender.name}")
    private String senderName;

    @Value("${email.sender.addr}")
    private String senderAddr;

    @Value("${email.login}")
    private String login;

    @Value("${email.publish.recipients}")
    private String publishRecipients;

    @Value("${uri.publish.mask}")
    private String publishUriMask;

    @Value("${service.basereg.uri}")
    private String baseregServiceUri;

    @Value("${service.ri.uri}")
    private String riServiceUri;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private CatalogElemRepository catalogElemRepository;

    @Autowired
    private PublishDataRepository publishDataRepository;

    public void publish(Doc doc, byte[] fileBytes, User signerUser) {
        String publishClassifierParams = doc.getDocType().getPublishClassifierParams();
        if (publishClassifierParams != null) {
            PublishData publishData = new PublishData(doc);
            String regNum = doc.getRegNum();
            String regDate = DateTimeUtil.toString(doc.getRegDateTime().toLocalDate());
            String fileName = doc.getId().toString() + ".pdf";
            String publishDate = DateTimeUtil.toString(LocalDate.now());
            String signer = signerUser.getFirstname() + " " + signerUser.getPatronym() + " " + signerUser.getLastname();
            String signerPosition = signerUser.getPosition();

            String docName = String.format(doc.getDocType().getPublishNameMask(), regNum, regDate);
            if (doc.getDocType().getId() == 2) {
                String agendaDate = "";
                DocValuedFields vf = doc.getDocValuedFields().stream()
                        .filter(f -> f.getValuedField().getField().getName().equals("Дата заседания")).findFirst().orElse(null);
                if (vf != null) {
                    agendaDate = DateTimeUtil.toString(vf.getValuedField().getValueDate().toLocalDate());
                }
                docName = String.format(doc.getDocType().getPublishNameMask(), regNum, agendaDate);
            }

            String[] topLevelClassifierParams = publishClassifierParams.split("\\|");

            String[] mosRuClassifierParams = topLevelClassifierParams[0].split(";");
            if (mosRuClassifierParams.length != 0) {
                publishMosRu(docName, publishDate, mosRuClassifierParams[0], mosRuClassifierParams[1],
                        fileName, fileBytes, publishData);
            }

            String[] baseRegClassifierParams = topLevelClassifierParams[1].split(";");
            if (baseRegClassifierParams.length != 0) {
                String uri = publishBaseReg(docName, baseRegClassifierParams[0], fileName, fileBytes, regNum, regDate,
                        signer, signerPosition, publishData);

                String[] riClassifierParams = topLevelClassifierParams[2].split(";");
                if (riClassifierParams.length != 0) {
                    publishRi(doc, docName, riClassifierParams[0], uri, publishData);
                }
            }
            publishDataRepository.save(publishData);
        }
    }

    private void publishRi(Doc doc, String docName, String docClass, String uri, PublishData publishData) {
        if (uri.equals("")) {
            publishData.setRiDateTime(LocalDateTime.now());
            publishData.setRi(false);
        } else {
            try {
                JSONObject query = new JSONObject();
                query.put("docType", docClass);
                query.put("docNumber", doc.getRegNum());
                query.put("docDate", doc.getRegDateTime().toLocalDate().toString());
                query.put("docTitle", docName);
                query.put("dateAccept", doc.getRegDateTime().toLocalDate().toString());
                query.put("contentUrl", uri);
                switch (doc.getDocType().getId()) {
                    case 2:
                        String agendaDateTime = "";
                        DocValuedFields vfAgendaDate = doc.getDocValuedFields().stream()
                                .filter(f -> f.getValuedField().getField().getName().equals("Дата заседания")).findFirst().orElse(null);
                        DocValuedFields vfAgendaTime = doc.getDocValuedFields().stream()
                                .filter(f -> f.getValuedField().getField().getName().equals("Время заседания")).findFirst().orElse(null);
                        if (vfAgendaDate != null && vfAgendaTime != null) {
                            LocalTime agendaTime = vfAgendaTime.getValuedField().getValueDateTime().toLocalTime();
                            int agendaHours = agendaTime.getHour();
                            int agendaMinutes = agendaTime.getMinute();
                            agendaDateTime = vfAgendaDate.getValuedField().getValueDate()
                                    .plusHours(agendaHours)
                                    .plusMinutes(agendaMinutes)
                                    .toString();
                        }
                        query.put("meetingDatePlan", agendaDateTime);

                        query.put("meetingAddress", "г. Москва, Вознесенский пер., д. 21, каб. 42а");

                        JSONArray jsonArrayOrgs = new JSONArray();
                        List<Organization> organizationList = doc.getDocValuedFields()
                                .stream().filter(f -> f.getValuedField().getField().getName().equals("Вопросы повестки"))
                                .flatMap(f -> f.getValuedField().getChildValuedField().stream())
                                .filter(f -> f.getField().getName().equals("Организация"))
                                .filter(f -> f.getValueInt() != null)
                                .map(f -> organizationRepository.findById(f.getValueInt()).orElse(null))
                                .filter(Objects::nonNull)
                                .collect(Collectors.toList());

                        for (Organization organization : organizationList) {
                            JSONObject organizationQuery = new JSONObject();
                            organizationQuery.put("inn", organization.getInn());
                            organizationQuery.put("ogrn", organization.getOgrn());
                            jsonArrayOrgs.add(organizationQuery);
                        }
                        query.put("organizations", jsonArrayOrgs);

                        JSONArray jsonArraySpheres = new JSONArray();
                        doc.getDocValuedFields()
                                .stream().filter(f -> f.getValuedField().getField().getName().equals("Вопросы повестки"))
                                .flatMap(f -> f.getValuedField().getChildValuedField().stream())
                                .filter(f -> f.getField().getName().equals("Сфера деятельности"))
                                .filter(f -> f.getCatalogElem() != null)
                                .map(f -> f.getCatalogElem().getValueStrPreposition())
                                .filter(Objects::nonNull)
                                .distinct()
                                .forEach(f -> jsonArraySpheres.add(f));
                        query.put("spheres", jsonArraySpheres);
                        break;
                }
                String JSONString = query.toJSONString();

                HttpClient httpClient = HttpClientBuilder.create().build();
                HttpPost request = new HttpPost(riServiceUri);
                StringEntity params = new StringEntity(JSONString, "UTF-8");
                params.setContentEncoding("UTF-8");
                params.setContentType("application/json");
                request.setEntity(params);
                HttpResponse response = httpClient.execute(request);
                if (response.getStatusLine().getStatusCode() == 200) {
                    publishData.setRi(true);
                } else {
                    publishData.setRi(false);
                }
                publishData.setRiDateTime(LocalDateTime.now());
            } catch (Exception ex) {
                LOG.error(ex.getMessage());
            }
        }
    }

    private String publishBaseReg(String docName, String docClass, String fileName, byte[] fileBytes,
                                  String regNum, String regDate, String signer, String signerPosition, PublishData publishData) {
        ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub binding;
        try {
            binding = (ru.gbuac.jaxws.basereg.BasicHttpBinding_IService1Stub)
                    new ru.gbuac.jaxws.basereg.Service1Locator(baseregServiceUri).getBasicHttpBinding_IService1();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }

        // Time out after a minute
        binding.setTimeout(60000);
        try {
            CreateDocumentFile[] files = {
                    new CreateDocumentFile(docName, fileBytes, fileName, null)
            };

            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            Calendar calendar  = Calendar.getInstance();
            calendar.setTime(df.parse(regDate));

            ru.gbuac.jaxws.basereg.CreateDocumentResponse response = binding.createDocument(new ru.gbuac.jaxws.basereg.
                    CreateDocumentRequest(calendar, null, files, null, null,
                    new DocStatus("Действует"), signerPosition, signer,
                    "Департамент экономической политики и развития города Москвы", "135d2a0b-dd6c-4d56-be6d-dc9e399c9621",
                    null, null, null, regNum, Integer.parseInt(docClass)));
            publishData.setBaseregDateTime(LocalDateTime.now());
            if (response.getStatus().equals(ResponseStatus.ok)) {
                publishData.setBasereg(response.getFilesId()[0]);
                return publishUriMask + response.getFilesId()[0];
            }
        }
        catch (RemoteException | ParseException re) {
            LOG.error(re.getMessage());
        }
        return "";
    }

    private void publishMosRu(String docName, String publishDate, String rubrname, String uri, String fileName,
                              byte[] fileBytes, PublishData publishData) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            message.setFrom(new InternetAddress(senderName + "<" + senderAddr + ">"));

            boolean multipart = true;

            MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

            String htmlMsg = "<p>\n" +
                    "    <strong>Дата:&nbsp " + publishDate + "</strong>\n" +
                    "</p>\n" +
                    "<table <table style=\"border-collapse: collapse;\" border=\"1\" width=\"97%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                    "    <tbody>\n" +
                    "        <tr>\n" +
                    "            <td width=\"35%\" valign=\"top\">\n" +
                    "                <p>\n" +
                    "                    <a name=\"l103\"></a>\n" +
                    "                    Наименование структурного подразделения\n" +
                    "                </p>\n" +
                    "            </td>\n" +
                    "            <td width=\"64%\" valign=\"top\">\n" +
                    "                <p>\n" +
                    "                    ИАС «Тариф»\n" +
                    "                </p>\n" +
                    "            </td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td width=\"35%\" valign=\"top\">\n" +
                    "                <p>\n" +
                    "                    Название документа/ информация\n" +
                    "                </p>\n" +
                    "            </td>\n" +
                    "            <td width=\"64%\" valign=\"top\">\n" +
                    "                <p>\n" +
                    "                    "+docName+"\n" +
                    "                </p>\n" +
                    "            </td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td width=\"35%\" valign=\"top\">\n" +
                    "                <p>\n" +
                    "                    Размещение на сайте\n" +
                    "                    <em>\n" +
                    "                        (прописать адрес страницы сайта, на которую необходимо\n" +
                    "                        установить информацию)\n" +
                    "                    </em>\n" +
                    "                </p>\n" +
                    "            </td>\n" +
                    "            <td width=\"64%\" valign=\"top\">\n" +
                    "                <p>\n" +
                    "                    " + rubrname + ",\n" +
                    "                    " + uri + "\n" +
                    "                </p>\n" +
                    "            </td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td width=\"35%\" valign=\"top\">\n" +
                    "                <p>\n" +
                    "                    Срок размещения в течение\n" +
                    "                </p>\n" +
                    "            </td>\n" +
                    "            <td width=\"64%\" valign=\"top\">\n" +
                    "                <p align=\"center\">\n" +
                    "                    <strong><u>3-х часов</u></strong>\n" +
                    "                </p>\n" +
                    "            </td>\n" +
                    "        </tr>\n" +
                    "    </tbody>\n" +
                    "</table>\n";

            helper.setText(htmlMsg, true);

            helper.setTo(InternetAddress.parse(publishRecipients));

            helper.setSubject("Заявка на размещение информации на Интернет-сайте Департамента экономической политики и развития города Москвы");

            helper.addAttachment(fileName, new ByteArrayResource(fileBytes));

            this.emailSender.send(message);

            publishData.setMosRu(true);
            publishData.setMosRuDateTime(LocalDateTime.now());
        }
        catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
