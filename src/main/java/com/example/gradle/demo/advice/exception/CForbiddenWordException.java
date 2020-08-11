package com.example.gradle.demo.advice.exception;

public class CForbiddenWordException extends RuntimeException {

    public CForbiddenWordException(String msg, Throwable t) {
        super(msg, t);
    }

    public CForbiddenWordException(String msg) {
        super(msg);
    }

    public CForbiddenWordException() {
        super();
    }
}
