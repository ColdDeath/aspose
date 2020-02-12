package ru.gbuac.util.exception;

import org.springframework.http.HttpStatus;

public class ResolutionUserNotFoundException extends ApplicationException {
    public static final String RESOLUTION_USER_NOT_FOUND_EXCEPTION = "exception.resolution.user-not-found";

    public ResolutionUserNotFoundException() {
        super(ErrorType.WRONG_REQUEST, RESOLUTION_USER_NOT_FOUND_EXCEPTION, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
