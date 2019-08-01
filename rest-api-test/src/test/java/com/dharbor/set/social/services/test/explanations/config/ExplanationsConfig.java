package com.dharbor.set.social.services.test.explanations.config;

import com.dharbor.set.social.services.test.config.ServerConfig;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author rveizaga
 */
public class ExplanationsConfig extends ServerConfig {

    @Value("${url}")
    private String url;

    @Value("${port}")
    private Integer port;

}
