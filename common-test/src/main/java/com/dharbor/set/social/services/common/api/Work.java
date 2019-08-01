package com.dharbor.set.social.services.common.api;

import com.dharbor.set.social.services.common.annotation.BusinessLogicException;
import com.dharbor.set.social.services.common.exception.HandledBusinessLogicException;

/**
 * @author rveizaga
 */
public abstract class Work {

    public final void doWork() throws Throwable {
        try {
            preProceed();

            proceed();

            postProceed();
        } catch (Throwable throwable) {
            throw handleProceedException(throwable);
        }
    }

    protected abstract void proceed() throws Throwable;

    protected abstract void preProceed() throws Throwable;

    protected abstract void postProceed() throws Throwable;

    private Throwable handleProceedException(Throwable source) {
        if (source.getClass().isAnnotationPresent(BusinessLogicException.class)) {
            return new HandledBusinessLogicException(source);
        }

        return source;
    }
}
