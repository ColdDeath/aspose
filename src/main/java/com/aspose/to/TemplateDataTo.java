package com.aspose.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.aspose.util.TaggedTable;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateDataTo {
    private byte[] template;
    private Map<String, String> simpleTags;
    private Map<String, TaggedTable> taggedTables;
    private Map<String, String> htmlTables;
    boolean isPDF;
}
