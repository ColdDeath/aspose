package ru.gbuac.controller.docvaluedfields;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gbuac.model.DocValuedFields;
import ru.gbuac.to.DocFieldsTo;

import java.util.List;

@RestController
@RequestMapping(value = DocValuedFieldsRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DocValuedFieldsRestController extends AbstractDocValuedFieldsRestController {
    public static final String REST_URL = "/rest/profile/docs/{docId}/fields";

    @Override
    @GetMapping
    public List<DocFieldsTo> getAllFull(@PathVariable("docId") int docId) {
        return super.getAllFull(docId);
    }

    @Override
    @GetMapping(value = "/merged")
    public List<DocFieldsTo> getAllMerged(@PathVariable("docId") int docId, @RequestParam("targetDocTypeId") int targetDocTypeId) {
        return super.getAllMerged(docId, targetDocTypeId);
    }
}
