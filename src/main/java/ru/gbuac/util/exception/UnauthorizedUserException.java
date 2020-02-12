package ru.gbuac.util.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedUserException extends ApplicationException {
    public static final String UNAUTHORIZED_USER_EXCEPTION = "exception.doc.unauthorizedUser";

    public UnauthorizedUserException() {
        super(ErrorType.VALIDATION_ERROR, UNAUTHORIZED_USER_EXCEPTION, HttpStatus.NOT_ACCEPTABLE);
    }
}
