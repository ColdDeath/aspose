package ru.gbuac.controller.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gbuac.model.Catalog;
import ru.gbuac.model.DocType;
import ru.gbuac.service.CatalogService;
import ru.gbuac.service.DocTypeService;

import java.util.List;

import static ru.gbuac.util.ValidationUtil.assureIdConsistent;
import static ru.gbuac.util.ValidationUtil.checkNew;

public abstract class AbstractCatalogRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    protected CatalogService catalogService;

    public Catalog get(int id) {
        LOG.info("get " + id);
        return catalogService.get(id);
    }

    public List<Catalog> getChildCatalogsByElementId(int elementId) {
        LOG.info("getChildCatalogByElementId " + elementId);
        return catalogService.getChildCatalogsByElementId(elementId);
    }

    public List<Catalog> getAll() {
        LOG.info("getAll");
        return catalogService.getAll();
    }

    public Catalog create(Catalog catalog) {
        LOG.info("create " + catalog);
        checkNew(catalog);
        return catalogService.save(catalog);
    }

    public Catalog update(Catalog catalog, int id) {
        LOG.info("update " + catalog);
        assureIdConsistent(catalog, id);
        return catalogService.update(catalog, id);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        catalogService.delete(id);
    }
}
