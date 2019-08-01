package com.dharbor.set.social.services.common.core;

import org.springframework.context.ApplicationContext;

/**
 * @author rveizaga
 */
public abstract class AbstractCoreCommandFactory {

    public <CMD extends CoreCommand> CMD createInstance(Class<CMD> commandClazz) {
        return getApplicationContext().getBean(commandClazz);
    }

    protected abstract ApplicationContext getApplicationContext();
}
