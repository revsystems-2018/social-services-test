package com.dharbor.set.social.services.test.common;

import com.dharbor.set.social.identity.data.api.dto.SessionUserDTO;
import com.dharbor.set.social.services.test.config.ServerConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomUtils;

/**
 * @author rveizaga
 */
public abstract class BaseTestUser extends AbstractTestUser {

    private String accountId;

    private String token;

    private SessionUserDTO sessionUserDTO;

    BaseTestUser(ServerConfig serverConfig) {
        super(serverConfig);
    }

    public RequestSpecification request() {
        return adapter().given()
                .port(serverConfig.getPort());
    }

    public void authenticate() {
        Response response = adapter().given()
                .port(serverConfig.getPort())
                .contentType(ContentType.JSON)
                .body(getCredentials())
                .expect()
                .statusCode(200)
                .when()
                .post("/set/social-services/identity/login");

        sessionUserDTO = response.as(SessionUserDTO.class);
    }

    public SessionUserDTO getSessionUserDTO() {
        return sessionUserDTO;
    }

    void sleep() {
        try {
            Thread.sleep(RandomUtils.nextLong(3000L, 4000L));
        } catch (InterruptedException e) {
            throw new UnsupportedOperationException("Unable to activate sleep timer ", e);
        }
    }
}
