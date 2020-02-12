package ru.gbuac.util.exception;

import org.springframework.http.HttpStatus;

public class ModificationQuestAnswerExistsException extends ApplicationException {
    public static final String MODIFICATION_QUEST_ANSWER_EXISTS_EXCEPTION = "exception.quest.modificationAnswerExists";

    public ModificationQuestAnswerExistsException() {
        super(ErrorType.VALIDATION_ERROR, MODIFICATION_QUEST_ANSWER_EXISTS_EXCEPTION, HttpStatus.NOT_ACCEPTABLE);
    }
}