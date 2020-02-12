package ru.gbuac.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.SafeHtml;
import ru.gbuac.model.DecisionType;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DocAgreementTo extends BaseTo {

    @JsonInclude
    Integer ordering;

    @JsonInclude
    Integer userId;

    @JsonInclude
    @SafeHtml
    String name;

    @JsonInclude
    @SafeHtml
    String fullName;

    @JsonInclude
    @SafeHtml
    String position;

    @JsonInclude
    LocalDateTime agreedDateTime;

    @JsonInclude
    @SafeHtml
    String comment;

    @JsonInclude
    DecisionType decisionType;

    @JsonInclude
    Integer returnedUserId;

    @JsonInclude
    boolean finalUser;

    @JsonInclude
    boolean currentUser;

    public DocAgreementTo(Integer id, Integer ordering, Integer userId, @SafeHtml String name, @SafeHtml String lastName,
                          @SafeHtml String firstName, @SafeHtml String patronym, @SafeHtml String email,
                          @SafeHtml String position, LocalDateTime agreedDateTime, @SafeHtml String comment,
                          DecisionType decisionType, Integer returnedUserId, boolean finalUser, boolean currentUser) {
        super(id);
        this.ordering = ordering;
        this.userId = userId;
        this.name = name;
        this.fullName = lastName + " " + firstName + " " + patronym;
        this.position = position;
        this.agreedDateTime = agreedDateTime;
        this.comment = comment;
        this.decisionType = decisionType;
        this.returnedUserId = returnedUserId;
        this.finalUser = finalUser;
        this.currentUser = currentUser;
    }
}
