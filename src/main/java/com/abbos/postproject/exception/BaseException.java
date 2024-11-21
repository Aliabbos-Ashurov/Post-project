package com.abbos.postproject.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.text.MessageFormat;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  17:11
 **/
@Getter
public class BaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;
    private final String code;

    public BaseException(HttpStatus httpStatus, String code, String message, Object... args) {
        super(MessageFormat.format(message, args));
        this.httpStatus = httpStatus;
        this.code = code;
    }
}
