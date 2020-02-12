package ru.gbuac.controller.docagreement;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gbuac.model.DocAgreement;
import ru.gbuac.to.DocAgreementTo;
import ru.gbuac.to.DocTo;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = DocAgreementRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DocAgreementRestController extends AbstractDocAgreementRestController {
    public static final String REST_URL = "/rest/profile/docs/{docId}/agreement";

    @Override
    @GetMapping(value = "/list")
    public List<DocAgreementTo> getAgreementList(@PathVariable("docId") int docId) {
        return super.getAgreementList(docId);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public DocAgreementTo updateOrCreate(@Valid @RequestBody DocAgreement docAgreement) {
        if (docAgreement.isNew()) {
            return super.create(docAgreement);
        } else {
            return super.update(docAgreement, docAgreement.getId());
        }
    }

    @PostMapping(value = "/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<DocAgreementTo> saveList(@Valid @RequestBody List<DocAgreement> agreementList,
                                         @PathVariable("docId") int docId) {
        return super.saveList(agreementList, docId);
    }

    @PostMapping(value = "/redirect", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<DocAgreementTo> redirect(@PathVariable("docId") int docId,
                                         @RequestParam(name = "targetUserId") int targetUserId,
                                         @RequestParam(name = "comment", defaultValue = "")String comment) {
        return super.redirect(docId, targetUserId, comment);
    }
}
