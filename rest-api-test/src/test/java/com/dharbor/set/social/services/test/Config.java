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
        com.dharbor.set.social.services.application.Config.class
})
//@EnableJUnitExtensions("com.dharbor.nexus.crm.rest.test")
public class Config {
}
