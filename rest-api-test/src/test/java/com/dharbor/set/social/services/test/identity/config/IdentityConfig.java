package com.dharbor.set.social.services.test.identity.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author rveizaga
 */
public class IdentityConfig {

    @Value("${persistence.login.url}")
    private String url;

}
