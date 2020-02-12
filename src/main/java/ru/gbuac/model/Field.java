package ru.gbuac.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "field")
public class Field extends NamedEntity {
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Field> childField;

    @Enumerated(EnumType.STRING)
    @Column(name = "fieldtype")
    private FieldType fieldType;

    @Column(name = "position_in_group")
    private Integer positionInGroup;

    @Column(name = "max_count")
    private Integer maxCount;

    private Integer length;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "catalog_id", nullable = true)
    private Catalog catalog;

    private Boolean appendix;

    private String tag;
}
