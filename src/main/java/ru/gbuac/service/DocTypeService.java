package ru.gbuac.service;

import ru.gbuac.model.DocType;
import ru.gbuac.util.exception.NotFoundException;

import java.util.List;

public interface DocTypeService {
    DocType get(int id) throws NotFoundException;

    List<DocType> getAll();

    List<DocType> getAllFiltered(String userName);

    DocType save(DocType docType);

    DocType update(DocType docType, int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;
}
