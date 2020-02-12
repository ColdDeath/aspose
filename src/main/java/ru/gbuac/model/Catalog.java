package ru.gbuac.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "catalog")
public class Catalog extends NamedEntity {
    @Column(name = "parent_catalog_id")
    private Integer parentCatalog;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "catalogtype_id")
    private CatalogType catalogType;
}
