package com.example.user_service.exc;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class GenericErrorResponse extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;


    public GenericErrorResponse(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}