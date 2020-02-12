package ru.gbuac.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "valuedfield")
public class ValuedField extends BaseEntity{
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ValuedField> childValuedField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id", nullable = false)
    private Field field;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalogelem_id", nullable = true)
    private CatalogElem catalogElem;

    @Column(name = "value_int")
    private Integer valueInt;

    @Column(name = "value_str")
    private String valueStr;

    @Column(name = "value_date")
    private LocalDateTime valueDate;

    @Column(name = "value_time")
    private LocalDateTime valueTime;

    @Column(name = "value_datetime")
    private LocalDateTime valueDateTime;

    public ValuedField(Integer id, List<ValuedField> childValuedField, Field field, CatalogElem catalogElem,
                       Integer valueInt, @SafeHtml String valueStr, LocalDateTime valueDate,
                       LocalDateTime valueTime, LocalDateTime valueDateTime) {
        super(id);
        this.childValuedField = childValuedField;
        this.field = field;
        this.catalogElem = catalogElem;
        this.valueInt = valueInt;
        this.valueStr = valueStr;
        this.valueDate = valueDate;
        this.valueTime = valueTime;
        this.valueDateTime = valueDateTime;
    }
}
