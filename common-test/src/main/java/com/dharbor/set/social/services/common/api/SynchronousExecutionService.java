package com.dharbor.set.social.services.common.api;

import com.dharbor.set.social.services.common.exception.HandledBusinessLogicException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rveizaga
 */
@Service
@Transactional(noRollbackFor = {HandledBusinessLogicException.class})
public class SynchronousExecutionService implements CommandExecutorService {

    @Override
    public void onExecute(Work workItem) throws Throwable {
        workItem.doWork();
    }
}
