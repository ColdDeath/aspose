package ru.gbuac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.gbuac.dao.DocNumberPrefixesRepository;
import ru.gbuac.dao.DocTypeRepository;
import ru.gbuac.model.DocNumberPrefixes;
import ru.gbuac.model.DocType;
import ru.gbuac.util.exception.NotFoundException;

import java.util.List;

import static ru.gbuac.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DocNumberPrefixesServiceImpl implements DocNumberPrefixesService {

    @Autowired
    private DocNumberPrefixesRepository docNumberPrefixesRepository;

    @Override
    public DocNumberPrefixes get(int id) throws NotFoundException {
        return checkNotFoundWithId(docNumberPrefixesRepository.findById(id).orElse(null), id);
    }

    @Override
    public List<DocNumberPrefixes> getAll() {
        return docNumberPrefixesRepository.findAll();
    }

    @Override
    public DocNumberPrefixes save(DocNumberPrefixes docNumberPrefixes) {
        Assert.notNull(docNumberPrefixes, "docNumberPrefixes must not be null");
        return docNumberPrefixesRepository.save(docNumberPrefixes);
    }

    @Override
    public DocNumberPrefixes update(DocNumberPrefixes docNumberPrefixes, int id) throws NotFoundException {
        Assert.notNull(docNumberPrefixes, "docNumberPrefixes must not be null");
        return checkNotFoundWithId(docNumberPrefixesRepository.save(docNumberPrefixes), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Assert.notNull(id, "docNumberPrefixes must not be null");
        checkNotFoundWithId(docNumberPrefixesRepository.delete(id)!= 0, id);
    }

    @Override
    public String getMaskByDocTypeId(int docTypeId) {
        Assert.notNull(docTypeId, "docNumberPrefixes must not be null");
        return docNumberPrefixesRepository.getMaskByDocTypeId(docTypeId);
    }
}
