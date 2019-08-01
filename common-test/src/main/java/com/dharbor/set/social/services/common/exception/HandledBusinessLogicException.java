package com.dharbor.set.social.services.common.exception;

/**
 * @author rveizaga
 */
public final class HandledBusinessLogicException extends Exception {

    private Throwable source;

    public HandledBusinessLogicException(Throwable cause) {
        super(cause);
        this.source = cause;
    }

    public Throwable getSource() {
        return source;
    }
}
