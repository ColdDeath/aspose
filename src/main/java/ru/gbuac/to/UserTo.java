package ru.gbuac.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.SafeHtml;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserTo extends BaseTo {
    @SafeHtml
    private String fullName;
    @SafeHtml
    private String phone;
    @SafeHtml
    private String position;

    public UserTo(Integer id, @SafeHtml String fullName) {
        super(id);
        this.fullName = fullName;
    }

    public UserTo(Integer id, @SafeHtml String fullName, @SafeHtml String phone, @SafeHtml String position) {
        super(id);
        this.fullName = fullName;
        this.phone = phone;
        this.position = position;
    }
}
