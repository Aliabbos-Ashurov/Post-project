package com.abbos.postproject.handler;

import com.abbos.postproject.dto.ErrorResponse;
import com.abbos.postproject.dto.Response;
import com.abbos.postproject.exception.BaseException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:28
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Response<ErrorResponse>> handleBaseExceptions(BaseException ex, HttpServletRequest request) {
        ex.printStackTrace();
        var errorResponse = ErrorResponse.of(ex.getCode(), ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(Response.error(
                ex.getHttpStatus().value(),
                errorResponse
        ), ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<ErrorResponse>> handleExceptions(Exception ex, HttpServletRequest request) {
        ex.printStackTrace();
        var errorResponse = ErrorResponse.of("INTERNAL SERVER ERROR", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(Response.error(
                500,
                errorResponse
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
