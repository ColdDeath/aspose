package ru.gbuac.controller.templater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.gbuac.service.TemplaterService;
import ru.gbuac.util.TaggedTable;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
