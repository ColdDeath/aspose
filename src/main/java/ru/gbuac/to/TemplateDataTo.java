package ru.gbuac.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javassist.bytecode.ByteArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.gbuac.util.TaggedTable;

import java.io.InputStream;
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
