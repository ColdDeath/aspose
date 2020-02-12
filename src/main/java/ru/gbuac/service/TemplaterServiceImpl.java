package ru.gbuac.service;

import org.springframework.stereotype.Service;
import ru.gbuac.util.TaggedTable;
import ru.gbuac.util.Templater;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
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
