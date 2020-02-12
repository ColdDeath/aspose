package com.aspose.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.aspose.service.TemplaterService;
import com.aspose.util.TaggedTable;

import java.util.Map;

public abstract class AbstractTemplaterRestController {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    TemplaterService templaterService;

    public byte[] generateDocFromTags(byte[] template, Map<String, String> simpleTags,
                                                     Map<String, TaggedTable> taggedTables,
                                                     Map<String, String> htmlTables, boolean isPDF) throws Exception {
        LOG.info("generateDocFromTags");
        return templaterService.generateDocFromTags(template, simpleTags, taggedTables, htmlTables, isPDF);
    }
}
