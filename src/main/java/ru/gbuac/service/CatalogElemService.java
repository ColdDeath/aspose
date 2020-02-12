package ru.gbuac.service;

import ru.gbuac.model.CatalogElem;
import ru.gbuac.to.CatalogElemTo;
import ru.gbuac.util.exception.NotFoundException;

import java.util.List;

public interface CatalogElemService {
    CatalogElem get(int id, int catalogId) throws NotFoundException;

    List<CatalogElemTo> getAll(int catalogId);

    List<CatalogElemTo> getAllByParentCatalogElem(int catalogId, int idParentCatalogElem);

    CatalogElem save(CatalogElem catalogElem);

    CatalogElem update(CatalogElem catalogElem, int id) throws NotFoundException;

    void delete(int id, int catalogId) throws NotFoundException;
}
