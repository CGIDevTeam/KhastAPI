package com.julien.juge.khast.api.utils.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message, Object... args) {
        super(String.format(message, args));
    }
}
