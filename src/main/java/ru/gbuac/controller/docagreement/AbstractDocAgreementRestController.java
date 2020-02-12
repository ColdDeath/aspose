package ru.gbuac.controller.docagreement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gbuac.AuthorizedUser;
import ru.gbuac.model.DocAgreement;
import ru.gbuac.service.DocAgreementService;
import ru.gbuac.to.DocAgreementTo;

import java.util.List;

import static ru.gbuac.util.ValidationUtil.assureIdConsistent;
import static ru.gbuac.util.ValidationUtil.checkNew;

public abstract class AbstractDocAgreementRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private DocAgreementService docAgreementService;

    public DocAgreement get(int id, int docId) {
        LOG.info("get " + id);
        return docAgreementService.get(id, docId);
    }

    public List<DocAgreementTo> getAgreementList(int docId) {
        LOG.info("getAgreementList");
        return docAgreementService.getAgreementList(docId);
    }

    public List<DocAgreement> getAll(int docId) {
        LOG.info("getAll");
        return docAgreementService.getAll(docId);
    }

    public DocAgreementTo create(DocAgreement docAgreement) {
        LOG.info("create " + docAgreement);
        checkNew(docAgreement);
        return docAgreementService.save(docAgreement);
    }

    public DocAgreementTo update(DocAgreement docAgreement, int id) {
        LOG.info("update " + docAgreement);
        assureIdConsistent(docAgreement, id);
        return docAgreementService.update(docAgreement, id);
    }

    public List<DocAgreementTo> saveList(List<DocAgreement> agreementList, int docId) {
        LOG.info("saveList " + agreementList);
        return docAgreementService.saveList(agreementList, docId);
    }

    public List<DocAgreementTo> redirect(int docId, int targetUserId, String comment) {
        LOG.info("redirect to targetUserId " + targetUserId);
        return docAgreementService.redirect(docId, targetUserId, comment, AuthorizedUser.getUserName());
    }

    public void delete(int id, int docId) {
        LOG.info("delete " + id);
        docAgreementService.delete(id, docId);
    }
}
