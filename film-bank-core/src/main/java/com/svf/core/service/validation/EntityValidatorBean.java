package com.svf.core.service.validation;

import com.svf.core.exceptions.ConstraintViolationException;
import com.svf.core.exceptions.EntityNotFoundException;

import javax.validation.Validator;
import java.util.Objects;
import java.util.Set;

/**
 * Created by stepanferubko
 */
public class EntityValidatorBean {

    private Validator validator;

    public EntityValidatorBean(Validator validator) {
        this.validator = validator;
    }

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public <T> T validate(T target) throws ConstraintViolationException, NullPointerException {
        return validate(target, false);
    }

    public <T> T validate(T target, boolean nullValueAllowed) throws ConstraintViolationException, NullPointerException {
        if (!nullValueAllowed) {
            Objects.requireNonNull(target, "Not null object is required");
        }

        Set errors = validator.validate(target);
        if (errors.size() > 0) {
            throw new ConstraintViolationException(errors);
        }
        return target;
    }

    public <T> T entityExists(T entity, Class<T> type, Object id) throws EntityNotFoundException {
        if (entity == null) {
            throw new EntityNotFoundException(id, type);
        }
        return entity;
    }
}
