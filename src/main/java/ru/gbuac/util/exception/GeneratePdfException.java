package ru.gbuac.util.exception;

import org.springframework.http.HttpStatus;

public class GeneratePdfException extends ApplicationException {
    public static final String GENERATE_PDF_EXCEPTION = "exception.doc.generatePdf";

    public GeneratePdfException() {
        super(ErrorType.WRONG_REQUEST, GENERATE_PDF_EXCEPTION, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
