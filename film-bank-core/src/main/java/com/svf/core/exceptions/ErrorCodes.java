package com.svf.core.exceptions;

/**
 * Created by stepanferubko
 */
public abstract class ErrorCodes {
    public static final String ENTITY_NOT_FOUND = "ENTITY_NOT_FOUND";
    public static final String NOT_READY = "NOT_READY";
    public static final String ACCESS_DENIED = "ACCESS_DENIED";
    public static final String NOT_ALLOWED = "NOT_ALLOWED";
    public static final String ILLEGAL_ARGUMENTS = "ILLEGAL_ARGUMENTS";
    public static final String UNEXPECTED_ERROR = "UNEXPECTED_ERROR";
    public static final String DATA_CONVERSION_ERROR = "DATA_CONVERSION_ERROR";
    public static final String UNEXPECTED_ENTITY_STATE = "UNEXPECTED_ENTITY_STATE";

    public static String generateErrorId(String source) {
        long time = System.currentTimeMillis();
        return source + time;
    }
}
