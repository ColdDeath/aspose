package ru.gbuac.controller.doctypefields;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gbuac.AuthorizedUser;
import ru.gbuac.model.DocTypeFields;
import ru.gbuac.service.DocTypeFieldsService;
import ru.gbuac.to.DocFieldsTo;

import java.util.List;

import static ru.gbuac.util.ValidationUtil.assureIdConsistent;
import static ru.gbuac.util.ValidationUtil.checkNew;

public abstract class AbstractDocTypeFieldsRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private DocTypeFieldsService docTypeFieldsService;

    public DocTypeFields get(int id, int docTypeId) {
        LOG.info("get " + id);
        return docTypeFieldsService.get(id, docTypeId);
    }

    public List<DocTypeFields> getAll(int docTypeId) {
        LOG.info("getAll");
        return docTypeFieldsService.getAll(docTypeId);
    }

    public List<DocFieldsTo> getAllFullByUserName(int docTypeId) {
        LOG.info("getAllFullByUserName");
        return docTypeFieldsService.getAllFullByUserName(docTypeId, AuthorizedUser.getUserName());
    }

    public DocTypeFields create(DocTypeFields docTypeFields) {
        LOG.info("create " + docTypeFields);
        checkNew(docTypeFields);
        return docTypeFieldsService.save(docTypeFields);
    }

    public DocTypeFields update(DocTypeFields docTypeFields, int id) {
        LOG.info("update " + docTypeFields);
        assureIdConsistent(docTypeFields, id);
        return docTypeFieldsService.update(docTypeFields, id);
    }

    public void delete(int id, int docTypeFieldsId) {
        LOG.info("delete " + id);
        docTypeFieldsService.delete(id, docTypeFieldsId);
    }
}
