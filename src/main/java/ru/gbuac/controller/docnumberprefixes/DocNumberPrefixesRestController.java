package ru.gbuac.controller.docnumberprefixes;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gbuac.model.DocNumberPrefixes;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = DocNumberPrefixesRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DocNumberPrefixesRestController extends AbstractDocNumberPrefixesRestController {
    public static final String REST_URL = "/rest/profile/docNumberPrefixes";

    @Override
    @GetMapping(value = "/{id}")
    public DocNumberPrefixes get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @GetMapping
    public List<DocNumberPrefixes> getAll() {
        return super.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public DocNumberPrefixes updateOrCreate(@Valid @RequestBody DocNumberPrefixes docNumberPrefixes) {
        if (docNumberPrefixes.isNew()) {
            return super.create(docNumberPrefixes);
        } else {
            return super.update(docNumberPrefixes, docNumberPrefixes.getId());
        }
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @Override
    @GetMapping(value = "/getMaskByDocTypeId/{docTypeId}")
    public String getMaskByDocTypeId(int docTypeId) {
        return super.getMaskByDocTypeId(docTypeId);
    }
}
