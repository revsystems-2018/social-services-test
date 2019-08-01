package com.dharbor.set.social.services.common.api;

/**
 * @author rveizaga
 */
public interface CommandExecutorService {

    void onExecute(Work workItem) throws Throwable;

}
