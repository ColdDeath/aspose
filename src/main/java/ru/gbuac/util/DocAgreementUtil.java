package ru.gbuac.util;

import ru.gbuac.model.DocAgreement;
import ru.gbuac.model.User;
import ru.gbuac.to.DocAgreementTo;

public class DocAgreementUtil {

    private DocAgreementUtil() {
    }

    public static DocAgreementTo asTo(DocAgreement docAgreement) {
        User user = docAgreement.getUser();
        User returnedUser = docAgreement.getReturnedUser();
        return new DocAgreementTo(docAgreement.getId(), docAgreement.getOrdering(), user.getId(),
                user.getName(), user.getLastname(), user.getFirstname(), user.getPatronym(), user.getEmail(),
                user.getPosition(), docAgreement.getAgreedDateTime(), docAgreement.getComment(),
                docAgreement.getDecisionType(), returnedUser != null ? returnedUser.getId() : null,
                docAgreement.isFinalUser(), docAgreement.isCurrentUser());
    }
}
