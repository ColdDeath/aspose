package ru.gbuac.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.SafeHtml;
import ru.gbuac.model.Department;
import ru.gbuac.model.DocStatus;
import ru.gbuac.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class DocItemTo extends BaseTo {
    private DocStatus docStatus;

    @SafeHtml
    private String regNum;

    private LocalDateTime regDateTime;

    @SafeHtml
    private String projectRegNum;

    private LocalDateTime projectRegDateTime;

    @SafeHtml
    private String currentAgreeFullName;

    private LocalDate controlDate;

    private boolean alarmControlDate;

    @SafeHtml
    private String executorDepartments;

    @SafeHtml
    private String executorUsers;

    @SafeHtml
    private String docType;

    public DocItemTo(Integer id, DocStatus docStatus, @SafeHtml String regNum, LocalDateTime regDateTime, @SafeHtml
            String projectRegNum, LocalDateTime projectRegDateTime, @SafeHtml String currentAgreeFullName,
                     @SafeHtml String docType) {
        super(id);
        this.docStatus = docStatus;
        this.regNum = regNum;
        this.regDateTime = regDateTime;
        this.projectRegNum = projectRegNum;
        this.projectRegDateTime = projectRegDateTime;
        this.currentAgreeFullName = currentAgreeFullName;
        this.docType = docType;
    }

    public DocItemTo(Integer id, DocStatus docStatus, @SafeHtml String regNum, LocalDateTime regDateTime,
                     @SafeHtml String projectRegNum, LocalDateTime projectRegDateTime, LocalDate controlDate, boolean alarmControlDate,
                     @SafeHtml String executorDepartments, @SafeHtml String executorUsers, @SafeHtml String docType) {
        super(id);
        this.docStatus = docStatus;
        this.regNum = regNum;
        this.regDateTime = regDateTime;
        this.projectRegNum = projectRegNum;
        this.projectRegDateTime = projectRegDateTime;
        this.controlDate = controlDate;
        this.alarmControlDate = alarmControlDate;
        this.executorDepartments = executorDepartments;
        this.executorUsers = executorUsers;
        this.docType = docType;
    }
}
