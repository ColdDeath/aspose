package ru.gbuac.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "doc_number_prefixes")
@NamedStoredProcedureQuery(
        name = "generateDocNumber",
        procedureName = "generateDocNumber",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "mask"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "optional")
        }
)
public class DocNumberPrefixes extends NamedEntity {

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "docNumberPrefixes")
    private List<DocType> docType;
}
