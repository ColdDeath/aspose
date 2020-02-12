package ru.gbuac.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocFieldsTo {
    @JsonIgnore
    private Integer id;

    private FieldTo field;

    private Integer position;

    public DocFieldsTo(Integer id, FieldTo field, Integer position) {
        this.id = id;
        this.field = field;
        this.position = position;
    }
}
