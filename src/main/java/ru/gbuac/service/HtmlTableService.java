package ru.gbuac.service;

import ru.gbuac.model.HtmlTable;
import ru.gbuac.util.exception.NotFoundException;

import java.util.List;

public interface HtmlTableService {
    HtmlTable get(int id) throws NotFoundException;

    List<HtmlTable> getAll();

    HtmlTable save(HtmlTable htmlTable);

    HtmlTable update(HtmlTable htmlTable, int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;
}
