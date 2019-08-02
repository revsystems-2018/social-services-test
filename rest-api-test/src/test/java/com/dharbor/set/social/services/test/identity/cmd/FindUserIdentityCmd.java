package com.dharbor.set.social.services.test.identity.cmd;

import com.dharbor.set.social.identity.data.domain.User;
import com.dharbor.set.social.services.common.annotation.SynchronousExecution;
import com.dharbor.set.social.services.common.core.CoreCommand;
import com.dharbor.set.social.services.test.restassured.RootTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author rveizaga
 */
@SynchronousExecution
public class FindUserIdentityCmd implements CoreCommand {

    private RootTest root;

    private User user;

    @Override
    public void onExecute() {

        Response response = root.request()
                .contentType(ContentType.JSON)
                .expect()
                .statusCode(200)
                .when()
                .get(root.getRegisterPath() + "/users/" + root.getUserId());

        user = response.as(User.class);
    }

    public User getUser() {
        return user;
    }

    public void setRoot(RootTest root) {
        this.root = root;
    }
}
