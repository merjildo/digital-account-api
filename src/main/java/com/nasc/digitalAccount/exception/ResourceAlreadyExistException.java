package com.nasc.digitalAccount.exception;

public final class ResourceAlreadyExistException extends RuntimeException {
    public ResourceAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAlreadyExistException(String message) {
        super(message);
    }

    public ResourceAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
