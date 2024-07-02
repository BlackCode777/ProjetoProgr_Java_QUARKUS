package com.blackcode.helpdesk.exceptions;

public class ObjectNotFoundExceptionService extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundExceptionService(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundExceptionService(String message) {
        super(message);
    }

}
