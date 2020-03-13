package com.example.demo.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 异常处理
 */
public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = 5022575393500654458L;

    public ValidateCodeException(String message) {
        super(message);
    }
}