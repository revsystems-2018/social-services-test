package com.dharbor.set.social.services.test.restassured;

import com.dharbor.set.social.services.test.config.ServerConfig;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author rveizaga
 */
@Component
public class RestAssuredAdapter {

    @Autowired
    private ServerConfig serverConfig;

    public RequestSpecification given() {
        return RestAssured.given();
    }

    @PostConstruct
    void onPostConstruct() {
        RestAssured.baseURI = serverConfig.getUrl();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
