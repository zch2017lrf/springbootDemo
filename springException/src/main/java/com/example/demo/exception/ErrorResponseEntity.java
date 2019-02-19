package com.example.demo.exception;

/**
 * @author Levin
 * @since 2018/6/1 0001
 */
public class ErrorResponseEntity {

    private int code;
    private String message;

    public ErrorResponseEntity(int value, String message) {
        this.code = value;
        this.message = message;

    }
    // 省略 get set

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}