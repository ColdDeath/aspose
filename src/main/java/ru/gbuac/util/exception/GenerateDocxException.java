package ru.gbuac.util.exception;

import org.springframework.http.HttpStatus;

public class GenerateDocxException extends ApplicationException {
    public static final String GENERATE_DOCX_EXCEPTION = "exception.doc.generateDocx";

    public GenerateDocxException() {
        super(ErrorType.WRONG_REQUEST, GENERATE_DOCX_EXCEPTION, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
