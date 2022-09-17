package com.nasc.digitalAccount.exception;

public class AccountException extends RuntimeException {
    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountException(String message) {
        super(message);
    }

    public AccountException(Throwable cause) {
        super(cause);
    }
}
