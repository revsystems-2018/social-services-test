package com.dharbor.set.social.services.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author rveizaga
 */
@Configuration
@ComponentScan("com.dharbor.set.social.services.test")
@Import({
        com.dharbor.set.social.services.common.Application.class,
        com.dharbor.set.social.services.application.Config.class
})
public class Config {
}
