package ru.gbuac.to;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.SafeHtml;
import ru.gbuac.model.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class DocNumberTo extends BaseEntity {
    @SafeHtml
    private String regNum;

    public DocNumberTo(Integer id, @SafeHtml String regNum) {
        super(id);
        this.regNum = regNum;
    }
}
