package com.aspose.service;

import com.aspose.util.TaggedTable;
import com.aspose.util.Templater;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TemplaterServiceImpl implements TemplaterService{
    @Override
    public byte[] generateDocFromTags(byte[] template, Map<String, String> simpleTags,
                                                     Map<String, TaggedTable> taggedTables,
                                                     Map<String, String> htmlTables, boolean isPDF) throws Exception {

        return Templater.fillTagsByDictionary(template, simpleTags, taggedTables, htmlTables, isPDF);
    }
}
