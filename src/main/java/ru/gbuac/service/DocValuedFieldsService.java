package ru.gbuac.service;

import ru.gbuac.model.DocTypeFields;
import ru.gbuac.model.DocValuedFields;
import ru.gbuac.to.DocFieldsTo;
import ru.gbuac.util.exception.NotFoundException;

import java.util.List;

public interface DocValuedFieldsService {
    DocValuedFields get(int id, int docId) throws NotFoundException;

    List<DocValuedFields> getAll(int docId);

    List<DocFieldsTo> getAllFull(int docId, String userName);

    List<DocFieldsTo> getAllMerged(int docId, int targetDocTypeId, String userName);

    DocValuedFields save(DocValuedFields docValuedFields);

    DocValuedFields update(DocValuedFields docValuedFields, int id) throws NotFoundException;

    void delete(int id, int docId) throws NotFoundException;
}
