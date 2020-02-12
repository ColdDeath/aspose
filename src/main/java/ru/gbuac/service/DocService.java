package ru.gbuac.service;

import org.springframework.web.multipart.MultipartFile;
import ru.gbuac.model.Doc;
import ru.gbuac.model.User;
import ru.gbuac.to.*;
import ru.gbuac.util.exception.FileUploadException;
import ru.gbuac.util.exception.GenerateDocxException;
import ru.gbuac.util.exception.GeneratePdfException;
import ru.gbuac.util.exception.NotFoundException;

import java.util.List;

public interface DocService {
    Doc get(int id) throws NotFoundException;

    DocTo getFullByUserName(int id, String userName) throws NotFoundException;

    List<Doc> getAllAgreementByUsername(String userName);

    List<Doc> getAllAgreementMoreDeadlineByUserName(String userName);

    List<Doc> getAllAgreementLessDeadlineByUserName(String userName);

    List<Doc> getAllAgreementMoreDeadlineByDepartment(String userName);

    List<Doc> getAllAgreementLessDeadlineByDepartment(String userName);

    List<Doc> getAllAgreedByUsername(String userName);

    List<Doc> getAllRegisteredByUsername(String userName);

    List<DocItemTo> getAll();

    List<Doc> getAllAgreement();

    List<Doc> getAllRegistered();

    List<DocItemTo> getAllInWorkByUserName(String userName);

    List<DocItemTo> getAllInWorkMoreDeadlineByUserName(String userName);

    List<DocItemTo> getAllInWorkLessDeadlineByUserName(String userName);

    List<DocItemTo> getAllInWorkMoreDeadlineByDepartment(String userName);

    List<DocItemTo> getAllInWorkLessDeadlineByDepartment(String userName);

    List<DocItemTo> getAllDistribution(String userName);

    List<DocItemTo> getAllDistributionMoreDeadlineByChiefUserName(String userName);

    List<DocItemTo> getAllDistributionLessDeadlineByChiefUserName(String userName);

    List<DocItemTo> getAllDistributionMoreDeadlineByDepartment(String userName);

    List<DocItemTo> getAllDistributionLessDeadlineByDepartment(String userName);

    List<DocItemTo> getAllDistributed(String userName);

    List<DocItemTo> getAllAtThisMounthOnControl(String userName);

    List<DocItemTo> getAllAtThisMounthOnControlCompletedInTime(String userName);

    List<DocItemTo> getAllAtThisMounthOnControlCompletedAfterTime(String userName);

    List<DocItemTo> getAllAtThisMounthOnControlNotCompleted(String userName);

    List<DocNumberTo> getRegNumbers();

    DocTo save(DocTo doc, String userName, String rootPath);

    DocTo update(DocTo docTo, int id, String userName, String rootPath, boolean delegatedRights) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    DocTo rejectDocAgreement(int id, String userName, String comment) throws NotFoundException;

    FileTo uploadFile(MultipartFile inputFile, String rootPath) throws FileUploadException;

    FileTo createDOCX(DocTo docTo, String rootPath) throws GenerateDocxException;

    FileTo createPDF(DocTo docTo, String rootPath) throws GeneratePdfException;
}
