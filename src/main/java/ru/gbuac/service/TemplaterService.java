package ru.gbuac.service;

import ru.gbuac.util.TaggedTable;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

public interface TemplaterService {
    byte[] generateDocFromTags(byte[] template, Map<String, String> simpleTags,
                                              Map<String, TaggedTable> taggedTables, Map<String, String> htmlTables,
                                              boolean isPDF) throws Exception;
}
