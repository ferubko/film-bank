package com.svf.core.controller;

import com.svf.core.exceptions.EntityNotFoundException;
import com.svf.core.exceptions.ErrorCodes;
import com.svf.core.integration.AbstractResponse;
import com.svf.core.integration.FaultResponseFactory;

import java.util.function.Consumer;

/**
 * Created by stepanferubko
 */
public abstract class AbstractController {
    protected <T extends AbstractResponse> T catchBusinessMethodException(T instance, EntityNotFoundExceptionRiskGeneratorFunc<T> serviceFunction, Consumer<Throwable> customErrorProcessor) {
        try {
            return serviceFunction.apply(instance);
        } catch (EntityNotFoundException e) {
            customErrorProcessor.accept(e);
            return FaultResponseFactory.notFoundErrorResponse(instance, e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            customErrorProcessor.accept(e);
            return FaultResponseFactory.errorResponse(instance, ErrorCodes.ILLEGAL_ARGUMENTS, e.getMessage());
        } catch (Throwable th) {
            customErrorProcessor.accept(th);
            return FaultResponseFactory.errorResponse(instance, ErrorCodes.UNEXPECTED_ERROR, th.getMessage());
        }
    }

    protected <T extends AbstractResponse> T catchEntityNotFoundException(T instance, EntityNotFoundExceptionRiskGeneratorFunc<T> serviceFunction, Consumer<Throwable> customErrorProcessor) {
        try {
            return serviceFunction.apply(instance);
        } catch (EntityNotFoundException e) {
            customErrorProcessor.accept(e);
            return FaultResponseFactory.notFoundErrorResponse(instance, e.getMessage());
        } catch (Throwable th) {
            customErrorProcessor.accept(th);
            return FaultResponseFactory.errorResponse(instance, ErrorCodes.UNEXPECTED_ERROR, th.getMessage());
        }
    }

    public interface EntityNotFoundExceptionRiskGeneratorFunc<T extends AbstractResponse> {
        T apply(T initialResponse) throws EntityNotFoundException;
    }
}
