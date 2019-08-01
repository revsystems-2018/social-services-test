package com.dharbor.set.social.services.test.common;

import com.dharbor.set.social.services.test.config.Constants;
import com.dharbor.set.social.services.test.config.ServerConfig;
import com.dharbor.set.social.services.test.restassured.RestAssuredAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rveizaga
 */
public abstract class AbstractTestUser {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractTestUser.class);

    final ServerConfig serverConfig;

    private String email;

    private String password;

    AbstractTestUser(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;

        initialize();
    }

    private void initialize() {
        email = serverConfig.getUserName();
        password = serverConfig.getPassword();
    }

    Map<String, Object> getCredentials() {
        Map<String, Object> instance = new HashMap<>();
        instance.put(Constants.EMAIL, email);
        instance.put(Constants.PASSWORD, password);

        return instance;
    }

    abstract RestAssuredAdapter adapter();

    abstract String registerPath();
}
