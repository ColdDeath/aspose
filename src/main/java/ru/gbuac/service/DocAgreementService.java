package ru.gbuac.service;

import ru.gbuac.model.DocAgreement;
import ru.gbuac.to.DocAgreementTo;
import ru.gbuac.util.exception.NotFoundException;
import java.util.List;

public interface DocAgreementService {
    DocAgreement get(int id, int docId) throws NotFoundException;

    List<DocAgreementTo> getAgreementList(int docId);

    List<DocAgreement> getAll(int docId);

    DocAgreementTo save(DocAgreement docAgreement);

    DocAgreementTo update(DocAgreement docAgreement, int id) throws NotFoundException;

    List<DocAgreementTo> saveList(List<DocAgreement> agreementList, int docId);

    List<DocAgreementTo> redirect(int docId, int targetUserId, String comment, String userName);

    void delete(int id, int docId) throws NotFoundException;
}
