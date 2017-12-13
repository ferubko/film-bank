package com.svf.core.exceptions;

import javax.validation.ConstraintViolation;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by stepanferubko
 */
public class ConstraintViolationException extends IllegalArgumentException {
    Set<ConstraintViolation<?>> violations;

    public ConstraintViolationException(Set<ConstraintViolation<?>> violations) {
        this.violations = violations;
    }

    public ConstraintViolationException(String s, Set<ConstraintViolation<?>> violations) {
        super(s);
        this.violations = violations;
    }

    public ConstraintViolationException(String message, Throwable cause, Set<ConstraintViolation<?>> violations) {
        super(message, cause);
        this.violations = violations;
    }

    public ConstraintViolationException(Throwable cause, Set<ConstraintViolation<?>> violations) {
        super(cause);
        this.violations = violations;
    }

    public Set<ConstraintViolation<?>> getViolations() {
        return violations;
    }

    public void setViolations(Set<ConstraintViolation<?>> violations) {
        this.violations = violations;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        String v = getViolationString();
        return (message != null) ? (message + " (violations: " + v + ")") : v;
    }

    private String getViolationString() {
        String string = this.violations.stream()
                .sorted(Comparator.comparing(v -> v.getPropertyPath().toString()))
                .map(v -> new StringBuilder("Violation(")
                        .append("message='").append(v.getMessage()).append("'")
                        .append(", property=").append(v.getPropertyPath())
                        .append(", bean=").append(v.getRootBeanClass())
                        .append(", constraint=").append(v.getConstraintDescriptor().getAnnotation().annotationType().getName())
                        .append(")"))
                .map(StringBuilder::toString)
                .collect(Collectors.joining(", "));
        return violations.size() > 1 ? '[' + string + ']' : string;
    }
}
