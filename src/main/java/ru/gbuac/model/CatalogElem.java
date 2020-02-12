package ru.gbuac.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "catalogelem")
public class CatalogElem extends BaseEntity {
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="parent_catalogelem_id")
    private CatalogElem idParentCatalogElem;

    @Column(name = "value_int")
    private String valueInt;

    @Column(name = "value_str")
    private String valueStr;

    @Column(name = "value_str_preposition")
    private String valueStrPreposition;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Catalog catalog;
}
