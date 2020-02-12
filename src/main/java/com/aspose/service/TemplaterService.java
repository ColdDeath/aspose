package com.aspose.service;

import com.aspose.util.TaggedTable;

import java.util.Map;

public interface TemplaterService {
    byte[] generateDocFromTags(byte[] template, Map<String, String> simpleTags,
                               Map<String, TaggedTable> taggedTables, Map<String, String> htmlTables,
                               boolean isPDF) throws Exception;
}
