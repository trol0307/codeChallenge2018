package com.pep.restapi.application.usecase;

public class UseCaseException extends Exception {

    public UseCaseException(String message, Throwable err) {
        super(message, err);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}