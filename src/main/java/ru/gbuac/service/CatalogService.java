package ru.gbuac.service;

import ru.gbuac.model.DocType;
import ru.gbuac.model.Catalog;
import ru.gbuac.util.exception.NotFoundException;

import java.util.List;

public interface CatalogService {
    Catalog get(int id) throws NotFoundException;

    List<Catalog> getChildCatalogsByElementId(int elementId);

    List<Catalog> getAll();

    Catalog save(Catalog catalog);

    Catalog update(Catalog catalog, int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;
}
