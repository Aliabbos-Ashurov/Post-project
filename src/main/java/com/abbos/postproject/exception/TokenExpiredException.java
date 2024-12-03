package com.abbos.postproject.exception;

import com.abbos.postproject.util.ErrorCode;
import org.springframework.http.HttpStatus;

public class TokenExpiredException extends BaseException {

    public TokenExpiredException(String message, Object... args) {
        super(HttpStatus.UNAUTHORIZED, ErrorCode.TOKEN_EXPIRED, message, args);
    }
}
