package com.dharbor.set.social.services.test.common;

import com.dharbor.set.social.services.test.config.ServerConfig;
import com.dharbor.set.social.services.test.explanations.ExplanationsRootTest;
import com.dharbor.set.social.services.test.restassured.RestAssuredAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author rveizaga
 */
@Configuration
public class serviceFactory {

    @Autowired
    private RestAssuredAdapter restAssuredAdapter;

    @Autowired
    private ServerConfig serverConfig;

    @Bean
    @Scope("prototype")
    public ExplanationsRootTest explanationsRootTest() {

        ExplanationsRootTestImpl instance = new ExplanationsRootTestImpl(serverConfig, restAssuredAdapter);

        instance.initialize();

        return instance;
    }
}
