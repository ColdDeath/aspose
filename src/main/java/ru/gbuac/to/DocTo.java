package ru.gbuac.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.SafeHtml;
import ru.gbuac.model.Department;
import ru.gbuac.model.DocAgreement;
import ru.gbuac.model.DocStatus;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class DocTo extends BaseTo {
    @SafeHtml
    private String regNum;

    private LocalDateTime regDateTime;

    @SafeHtml
    private String projectRegNum;

    private LocalDateTime projectRegDateTime = LocalDateTime.now();

    private LocalDateTime insertDateTime = LocalDateTime.now();

    private Integer docTypeId;

    private DocStatus docStatus;

    private Boolean finalStage;

    private Boolean canAgree;

    private Boolean canWork;

    private Boolean canDistribute;

    @SafeHtml
    private String UrlPDF;

    private UserTo initialUser;

    private Integer finalUserId;

    private Boolean finalDoc;

    @SafeHtml
    private String comment;

    private List<Integer> executorDepartmentsIds;

    private List<Integer> executorUsersIds;

    private List<DocFieldsTo> childFields;

    private Integer parentDocId;

    public DocTo(Integer id, @SafeHtml String regNum, LocalDateTime regDateTime, @SafeHtml String projectRegNum,
                 LocalDateTime projectRegDateTime, LocalDateTime insertDateTime, Integer docTypeId, DocStatus docStatus,
                 Boolean finalStage, Boolean canAgree, Boolean canWork, Boolean canDistribute, @SafeHtml String urlPDF, UserTo initialUser,
                 Integer finalUserId, Boolean finalDoc, @SafeHtml String comment, List<Integer> executorDepartmentsIds,
                 List<Integer> executorUsersIds, List<DocFieldsTo> childFields, Integer parentDocId) {
        super(id);
        this.regNum = regNum;
        this.regDateTime = regDateTime;
        this.projectRegNum = projectRegNum;
        this.projectRegDateTime = projectRegDateTime;
        this.insertDateTime = insertDateTime;
        this.docTypeId = docTypeId;
        this.docStatus = docStatus;
        this.finalStage = finalStage;
        this.canAgree = canAgree;
        this.canWork = canWork;
        this.canDistribute = canDistribute;
        this.UrlPDF = urlPDF;
        this.initialUser = initialUser;
        this.finalUserId = finalUserId;
        this.finalDoc = finalDoc;
        this.comment = comment;
        this.executorDepartmentsIds = executorDepartmentsIds;
        this.executorUsersIds = executorUsersIds;
        this.childFields = childFields;
        this.parentDocId = parentDocId;
    }
}
