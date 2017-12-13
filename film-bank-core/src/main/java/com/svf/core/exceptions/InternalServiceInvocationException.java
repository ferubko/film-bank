package com.svf.core.exceptions;

/**
 * Created by stepanferubko
 */
public class InternalServiceInvocationException extends Exception {
    private String errorCode;
    private String errorMessage;

    public InternalServiceInvocationException(String errorCode, String errorMessage) {
        super(String.format("code='%s' message='%s'", errorCode, errorMessage));
        this.errorCode = errorCode == null ? ErrorCodes.UNEXPECTED_ERROR : errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
