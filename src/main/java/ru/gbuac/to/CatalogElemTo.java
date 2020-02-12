package ru.gbuac.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CatalogElemTo extends BaseTo {
    private Integer idParentCatalogElem;

    private String valueInt;

    private String valueStr;

    private String valueStrPreposition;

    private Integer catalogId;

    public CatalogElemTo(Integer id, Integer idParentCatalogElem, String valueInt, String valueStr,
                         String valueStrPreposition, Integer catalogId) {
        super(id);
        this.idParentCatalogElem = idParentCatalogElem;
        this.valueInt = valueInt;
        this.valueStr = valueStr;
        this.valueStrPreposition = valueStrPreposition;
        this.catalogId = catalogId;
    }
}
