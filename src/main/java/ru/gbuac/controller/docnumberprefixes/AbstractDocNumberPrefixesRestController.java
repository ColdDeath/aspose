package ru.gbuac.controller.docnumberprefixes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gbuac.model.DocNumberPrefixes;
import ru.gbuac.service.DocNumberPrefixesService;
import java.util.List;
import static ru.gbuac.util.ValidationUtil.assureIdConsistent;
import static ru.gbuac.util.ValidationUtil.checkNew;

public abstract class AbstractDocNumberPrefixesRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    protected DocNumberPrefixesService docNumberPrefixesService;

    public DocNumberPrefixes get(int id) {
        LOG.info("get " + id);
        return docNumberPrefixesService.get(id);
    }

    public List<DocNumberPrefixes> getAll() {
        LOG.info("getAll");
        return docNumberPrefixesService.getAll();
    }

    public DocNumberPrefixes create(DocNumberPrefixes docNumberPrefixes) {
        LOG.info("create " + docNumberPrefixes);
        checkNew(docNumberPrefixes);
        return docNumberPrefixesService.save(docNumberPrefixes);
    }

    public DocNumberPrefixes update(DocNumberPrefixes docNumberPrefixes, int id) {
        LOG.info("update " + docNumberPrefixes);
        assureIdConsistent(docNumberPrefixes, id);
        return docNumberPrefixesService.update(docNumberPrefixes, id);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        docNumberPrefixesService.delete(id);
    }

    public String getMaskByDocTypeId(int docTypeId) {
        LOG.info("getMaskByDocTypeId");
        return docNumberPrefixesService.getMaskByDocTypeId(docTypeId);
    }
}
