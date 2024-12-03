package com.abbos.postproject.exception;

import com.abbos.postproject.util.ErrorCode;
import org.springframework.http.HttpStatus;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  17:13
 **/
public class UserAlreadyExistException extends BaseException {

    public UserAlreadyExistException(String message, Object... args) {
        super(HttpStatus.CONFLICT, ErrorCode.USER_ALREADY_EXIST, message, args);
    }
}
