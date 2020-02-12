package ru.gbuac.service;

import ru.gbuac.model.DocNumberPrefixes;
import ru.gbuac.util.exception.NotFoundException;

import java.util.List;

public interface DocNumberPrefixesService {
    DocNumberPrefixes get(int id) throws NotFoundException;

    List<DocNumberPrefixes> getAll();

    DocNumberPrefixes save(DocNumberPrefixes docNumberPrefixes);

    DocNumberPrefixes update(DocNumberPrefixes docNumberPrefixes, int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    String getMaskByDocTypeId(int docTypeId);
}
