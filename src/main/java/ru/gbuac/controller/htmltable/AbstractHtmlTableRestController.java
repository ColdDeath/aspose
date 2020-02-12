package ru.gbuac.controller.htmltable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gbuac.model.HtmlTable;
import ru.gbuac.service.HtmlTableService;
import java.util.List;

import static ru.gbuac.util.ValidationUtil.assureIdConsistent;
import static ru.gbuac.util.ValidationUtil.checkNew;

public class AbstractHtmlTableRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    HtmlTableService htmlTableService;

    public HtmlTable get(int id) {
        LOG.info("get " + id);
        return htmlTableService.get(id);
    }

    List<HtmlTable> getAll() {
        LOG.info("getAll");
        return htmlTableService.getAll();
    }

    public HtmlTable create(HtmlTable htmlTable) {
        LOG.info("create " + htmlTable);
        checkNew(htmlTable);
        return htmlTableService.save(htmlTable);
    }

    public HtmlTable update(HtmlTable htmlTable, int id) {
        LOG.info("update " + htmlTable);
        assureIdConsistent(htmlTable, id);
        return htmlTableService.update(htmlTable, id);
    }

    void delete(int id) {
        LOG.info("delete");
        htmlTableService.delete(id);
    }
}
