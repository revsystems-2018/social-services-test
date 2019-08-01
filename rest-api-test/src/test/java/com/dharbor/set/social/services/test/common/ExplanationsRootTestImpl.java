package com.dharbor.set.social.services.test.common;

import com.dharbor.set.social.services.test.restassured.RestAssuredAdapter;
import com.dharbor.set.social.services.test.explanations.ExplanationsRootTest;
import com.dharbor.set.social.services.test.explanations.config.ExplanationsConfig;
import io.restassured.specification.RequestSpecification;

/**
 * @author rveizaga
 */
class ExplanationsRootTestImpl implements ExplanationsRootTest {

    private final BaseTestUser delegate;

    public ExplanationsRootTestImpl(ExplanationsConfig explanationsConfig,
                                    RestAssuredAdapter restAssuredAdapter) {

        delegate = new BaseTestUser(explanationsConfig) {
            @Override
            RestAssuredAdapter adapter() {
                return restAssuredAdapter;
            }

            @Override
            String registerPath() {
                return "/set/social-services/explanations";
            }
        };
    }

    @Override
    public void initialize() {

    }

    @Override
    public String getUserId() {
        return delegate.getSessionUserDTO().getUserId();
    }

    @Override
    public RequestSpecification request() {
        return delegate.request();
    }
}
