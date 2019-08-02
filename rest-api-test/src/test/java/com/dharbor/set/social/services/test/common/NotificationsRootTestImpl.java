package com.dharbor.set.social.services.test.common;

import com.dharbor.set.social.services.test.config.Constants;
import com.dharbor.set.social.services.test.config.ServerConfig;
import com.dharbor.set.social.services.test.notifications.NotificationsRootTest;
import com.dharbor.set.social.services.test.restassured.RestAssuredAdapter;
import io.restassured.specification.RequestSpecification;

/**
 * @author rveizaga
 */
public class NotificationsRootTestImpl implements NotificationsRootTest {

    private final BaseTestUser delegate;

    public NotificationsRootTestImpl(ServerConfig serverConfig,
                                     RestAssuredAdapter restAssuredAdapter) {

        delegate = new BaseTestUser(serverConfig) {
            @Override
            RestAssuredAdapter adapter() {
                return restAssuredAdapter;
            }

            @Override
            String registerPath() {
                return "/set/social-services/notifications";
            }
        };
    }

    @Override
    public void initialize() {
        delegate.authenticate();
    }

    @Override
    public String getUserId() {
        return delegate.getSessionUserDTO().getUserId();
    }

    @Override
    public String getResourceId() {
        return Constants.nextResourceId();
    }

    @Override
    public RequestSpecification request() {
        return delegate.request();
    }

    @Override
    public String getRegisterPath() {
        return delegate.registerPath();
    }
}
