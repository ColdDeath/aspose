package ru.gbuac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.gbuac.dao.HtmlTableRepository;
import ru.gbuac.model.HtmlTable;
import ru.gbuac.util.exception.NotFoundException;

import java.util.List;

import static ru.gbuac.util.ValidationUtil.checkNotFoundWithId;

@Service
public class HtmlTableServiceImpl implements HtmlTableService {

    @Autowired
    private HtmlTableRepository htmlTableRepository;

    @Override
    public HtmlTable get(int id) throws NotFoundException {
        return checkNotFoundWithId(htmlTableRepository.findById(id).orElse(null), id);
    }

    @Override
    public List<HtmlTable> getAll() {
        return htmlTableRepository.findAll();
    }

    @Override
    public HtmlTable save(HtmlTable htmlTable) {
        return htmlTableRepository.save(htmlTable);
    }

    @Override
    public HtmlTable update(HtmlTable htmlTable, int id) throws NotFoundException {
        Assert.notNull(htmlTable, "htmlTable must not be null");
        return checkNotFoundWithId(htmlTableRepository.save(htmlTable), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        htmlTableRepository.delete(id);
    }
}
