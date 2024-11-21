package com.abbos.postproject.exception;

import com.abbos.postproject.util.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  19:14
 **/
public class AccessException extends BaseException {

    public AccessException(String message, Object... args) {
        super(HttpStatus.FORBIDDEN, ErrorCode.FORBIDDEN, message, args);
    }
}
