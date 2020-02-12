package ru.gbuac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.gbuac.dao.CatalogElemRepository;
import ru.gbuac.model.CatalogElem;
import ru.gbuac.to.CatalogElemTo;
import ru.gbuac.util.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import static ru.gbuac.util.ValidationUtil.checkNotFoundWithId;

@Service
public class CatalogElemServiceImpl implements CatalogElemService{

    @Autowired
    private CatalogElemRepository catalogElemRepository;

    @Override
    public CatalogElem get(int id, int catalogId) throws NotFoundException {
        CatalogElem catalogElem = catalogElemRepository.findById(id).orElse(null);
        return checkNotFoundWithId(catalogElem != null && catalogElem.getCatalog().getId() == catalogId ? catalogElem : null, id);
    }

    @Override
    public List<CatalogElemTo> getAll(int catalogId) {
        List<CatalogElem> catalogElems = catalogElemRepository.getAll(catalogId);
        List<CatalogElemTo> catalogElemTos = new ArrayList<>();
        for (CatalogElem c : catalogElems) {
            catalogElemTos.add(new CatalogElemTo(c.getId(), null, c.getValueInt(),
                    c.getValueStr(), c.getValueStrPreposition(), c.getCatalog().getId()));
        }

        return catalogElemTos;
    }

    @Override
    public List<CatalogElemTo> getAllByParentCatalogElem(int catalogId, int idParentCatalogElem) {
        List<CatalogElem> catalogElems = catalogElemRepository.getAllByParentCatalogElem(catalogId, idParentCatalogElem);
        List<CatalogElemTo> catalogElemTos = new ArrayList<>();
        for (CatalogElem c : catalogElems) {
            catalogElemTos.add(new CatalogElemTo(c.getId(), null, c.getValueInt(),
                    c.getValueStr(), c.getValueStrPreposition(), c.getCatalog().getId()));
        }

        return catalogElemTos;
    }

    @Override
    public CatalogElem save(CatalogElem catalogElem) {
        Assert.notNull(catalogElem, "catalogElem must not be null");
        return catalogElemRepository.save(catalogElem);
    }

    @Override
    public CatalogElem update(CatalogElem catalogElem, int id) throws NotFoundException {
        Assert.notNull(catalogElem, "catalogElem must not be null");
        return checkNotFoundWithId(catalogElemRepository.save(catalogElem),id);
    }

    @Override
    public void delete(int id, int catalogElem) throws NotFoundException {
        Assert.notNull(id, "catalogElem must not be null");
        checkNotFoundWithId(catalogElemRepository.delete(id, catalogElem) != 0, id);
    }
}
