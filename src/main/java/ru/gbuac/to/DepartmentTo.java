package ru.gbuac.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.SafeHtml;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class DepartmentTo extends BaseTo {
    @SafeHtml
    private String name;

    public DepartmentTo(Integer id, @SafeHtml String name) {
        super(id);
        this.name = name;
    }
}
