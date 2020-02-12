package ru.gbuac.controller.htmltable;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gbuac.controller.user.UserRestController;
import ru.gbuac.model.HtmlTable;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = HtmlTableRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class HtmlTableRestController extends AbstractHtmlTableRestController {
    public static final String REST_URL = "/rest/profile/htmltables";

    @Override
    @GetMapping(value = "/{id}")
    public HtmlTable get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @GetMapping
    List<HtmlTable> getAll() {
        return super.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public HtmlTable updateOrCreate(@Valid @RequestBody HtmlTable htmlTable) {
        if (htmlTable.isNew()) {
            return super.create(htmlTable);
        } else {
            return super.update(htmlTable, htmlTable.getId());
        }
    }

    @Override
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable("id") int id) {
        super.delete(id);
    }
}
