package ru.gbuac.util.exception;

import org.springframework.http.HttpStatus;

public class FileUploadException extends ApplicationException {
    public static final String FILE_UPLOAD_EXCEPTION = "exception.doc.fileupload";

    public FileUploadException() {
        super(ErrorType.WRONG_REQUEST, FILE_UPLOAD_EXCEPTION, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
