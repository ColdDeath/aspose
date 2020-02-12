package ru.gbuac.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class OrganizationTo extends BaseTo {
    private String shortNameLf;

    public OrganizationTo(Integer id, String shortNameLf) {
        super(id);
        this.shortNameLf = shortNameLf;
    }
}
