package com.dharbor.set.social.services.test.restassured;

import io.restassured.specification.RequestSpecification;

/**
 * @author rveizaga
 */
public interface RootTest {

    String getUserId();

    RequestSpecification request();

}
