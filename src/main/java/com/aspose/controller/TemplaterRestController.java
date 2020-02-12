package com.aspose.controller;

import com.aspose.to.TemplateDataTo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = TemplaterRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class TemplaterRestController extends AbstractTemplaterRestController {
    public static final String REST_URL = "/rest/documents";

    @PostMapping(value = "/generate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public byte[] generateDocFromTags(@Valid @RequestBody TemplateDataTo templateDataTo) throws Exception {
        return super.generateDocFromTags(templateDataTo.getTemplate(), templateDataTo.getSimpleTags(),
                templateDataTo.getTaggedTables(), templateDataTo.getHtmlTables(), templateDataTo.isPDF());
    }
}
