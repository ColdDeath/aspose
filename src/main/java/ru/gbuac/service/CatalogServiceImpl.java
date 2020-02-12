package ru.gbuac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.gbuac.dao.CatalogElemRepository;
import ru.gbuac.dao.CatalogRepository;
import ru.gbuac.model.Catalog;
import ru.gbuac.model.CatalogElem;
import ru.gbuac.util.exception.NotFoundException;
import java.util.List;
import static ru.gbuac.util.ValidationUtil.checkNotFoundWithId;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private CatalogElemRepository catalogElemRepository;

    @Override
    public Catalog get(int id) throws NotFoundException {
        return checkNotFoundWithId(catalogRepository.findById(id).orElse(null), id);
    }

    @Override
    public List<Catalog> getChildCatalogsByElementId(int elementId) throws NotFoundException {
        return catalogElemRepository.getCatalogChildsByElem(elementId);
    }

    @Override
    public List<Catalog> getAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog save(Catalog catalog) {
        Assert.notNull(catalog, "catalog must not be null");
        return catalogRepository.save(catalog);
    }

    @Override
    public Catalog update(Catalog catalog, int id) throws NotFoundException {
        Assert.notNull(catalog, "catalog must not be null");
        Catalog savedCatalog = checkNotFoundWithId(catalogRepository.save(catalog), id);
        return savedCatalog;
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Assert.notNull(id, "catalog must not be null");
        checkNotFoundWithId(catalogRepository.delete(id)!= 0, id);
    }
}
