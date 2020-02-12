package ru.gbuac.util.exception;

import org.springframework.http.HttpStatus;

public class IllegalResolutionUserException extends ApplicationException {
    public static final String ILLEGEL_RESOLUTION_USER_EXCEPTION = "exception.resolution.illegal-user";

    public IllegalResolutionUserException() {
        super(ErrorType.WRONG_REQUEST, ILLEGEL_RESOLUTION_USER_EXCEPTION, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
