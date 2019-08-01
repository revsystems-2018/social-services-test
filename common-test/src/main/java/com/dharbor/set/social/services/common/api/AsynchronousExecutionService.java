package com.dharbor.set.social.services.common.api;

import com.dharbor.set.social.services.common.exception.HandledBusinessLogicException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rveizaga
 */

@Service
@Transactional(
        propagation = Propagation.REQUIRES_NEW,
        noRollbackFor = {HandledBusinessLogicException.class}
)
public class AsynchronousExecutionService implements CommandExecutorService{

    @Override
    public void onExecute(Work workItem) throws Throwable {
        workItem.doWork();
    }
}
