package com.dharbor.set.social.services.common.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author rveizaga
 */
@Component
public class CoreCommandFactoryProducer implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean
    @Scope(value = "prototype")
    public AbstractCoreCommandFactory coreCommandFactory() {
        return new AbstractCoreCommandFactory() {
            @Override
            protected ApplicationContext getApplicationContext() {
                return applicationContext;
            }
        };
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
