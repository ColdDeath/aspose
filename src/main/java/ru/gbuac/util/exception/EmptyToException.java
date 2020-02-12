package ru.gbuac.util.exception;

import org.springframework.http.HttpStatus;

public class EmptyToException extends ApplicationException {
    public static final String EMPTY_TO_EXCEPTION = "exception.doc.emptyTo";

    public EmptyToException() {
        super(ErrorType.WRONG_REQUEST, EMPTY_TO_EXCEPTION, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
