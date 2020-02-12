package ru.gbuac.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "doc_valuedfields")
public class DocValuedFields extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Doc doc;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "valuedfield_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ValuedField valuedField;

    @NotNull
    private Integer position;

    public DocValuedFields(Integer id, Doc doc, ValuedField valuedField, @NotNull Integer position) {
        super(id);
        this.doc = doc;
        this.valuedField = valuedField;
        this.position = position;
    }
}
