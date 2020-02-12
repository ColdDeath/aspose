package ru.gbuac.controller.docvaluedfields;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gbuac.AuthorizedUser;
import ru.gbuac.model.DocValuedFields;
import ru.gbuac.service.DocValuedFieldsService;
import ru.gbuac.to.DocFieldsTo;

import java.util.List;

import static ru.gbuac.util.ValidationUtil.assureIdConsistent;
import static ru.gbuac.util.ValidationUtil.checkNew;

public abstract class AbstractDocValuedFieldsRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private DocValuedFieldsService docValuedFieldsService;

    public DocValuedFields get(int id, int docId) {
        LOG.info("get " + id);
        return docValuedFieldsService.get(id, docId);
    }

    public List<DocValuedFields> getAll(int docId) {
        LOG.info("getAll");
        return docValuedFieldsService.getAll(docId);
    }

    public List<DocFieldsTo> getAllFull(int docId) {
        LOG.info("getAllFull");
        return docValuedFieldsService.getAllFull(docId, AuthorizedUser.getUserName());
    }

    public List<DocFieldsTo> getAllMerged(int docId, int targetDocTypeId) {
        LOG.info("getAllMerged");
        return docValuedFieldsService.getAllMerged(docId, targetDocTypeId, AuthorizedUser.getUserName());
    }

    public DocValuedFields create(DocValuedFields docValuedFields) {
        LOG.info("create " + docValuedFields);
        checkNew(docValuedFields);
        return docValuedFieldsService.save(docValuedFields);
    }

    public DocValuedFields update(DocValuedFields docValuedFields, int id) {
        LOG.info("update " + docValuedFields);
        assureIdConsistent(docValuedFields, id);
        return docValuedFieldsService.update(docValuedFields, id);
    }

    public void delete(int id, int docValuedFieldsId) {
        LOG.info("delete " + id);
        docValuedFieldsService.delete(id, docValuedFieldsId);
    }
}
