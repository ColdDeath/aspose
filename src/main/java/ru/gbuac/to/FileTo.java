package ru.gbuac.to;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.SafeHtml;

@Data
@NoArgsConstructor
public class FileTo {
    @SafeHtml
    String fileUrl;

    public FileTo(@SafeHtml String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
