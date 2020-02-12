package ru.gbuac.controller.doctypefields;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gbuac.model.DocTypeFields;

import java.util.List;

@RestController
@RequestMapping(value = AdminDocTypeFieldsRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminDocTypeFieldsRestController extends AbstractDocTypeFieldsRestController {
    public static final String REST_URL = "/rest/admin/doctypes/{docTypeId}/docTypeFields";

    @Override
    @GetMapping
    public List<DocTypeFields> getAll(@PathVariable("docTypeId") int docTypeId) {
        return super.getAll(docTypeId);
    }


}
