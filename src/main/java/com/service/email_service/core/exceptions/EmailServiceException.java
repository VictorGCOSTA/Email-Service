package com.service.email_service.core.exceptions;

public class EmailServiceException extends RuntimeException {
    private static final String message = "An error occurred while sending the email";
    public EmailServiceException() {
        super(message);
    }
    public EmailServiceException(Throwable cause) {
        super(message, cause);
    }
}
