package ru.gbuac.controller.doctype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gbuac.AuthorizedUser;
import ru.gbuac.model.DocType;
import ru.gbuac.service.DocTypeService;

import java.util.List;

import static ru.gbuac.util.ValidationUtil.assureIdConsistent;
import static ru.gbuac.util.ValidationUtil.checkNew;

public abstract class AbstractDocTypeRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    protected DocTypeService docTypeService;

    public DocType get(int id) {
        LOG.info("get " + id);
        return docTypeService.get(id);
    }

    public List<DocType> getAll() {
        LOG.info("getAll");
        return docTypeService.getAll();
    }

    public List<DocType> getAllFiltered() {
        LOG.info("getAll");
        return docTypeService.getAllFiltered(AuthorizedUser.getUserName());
    }

    public DocType create(DocType docType) {
        LOG.info("create " + docType);
        checkNew(docType);
        return docTypeService.save(docType);
    }

    public DocType update(DocType docType, int id) {
        LOG.info("update " + docType);
        assureIdConsistent(docType, id);
        return docTypeService.update(docType, id);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        docTypeService.delete(id);
    }
}
