package com.genka.cleancommerce.application.exceptions;

public class CredentialAlreadyInUseException extends RuntimeException {
    public CredentialAlreadyInUseException(String msg) {
        super(msg);
    }
}
