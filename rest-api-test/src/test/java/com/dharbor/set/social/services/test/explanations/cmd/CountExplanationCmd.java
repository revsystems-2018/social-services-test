package com.dharbor.set.social.services.test.explanations.cmd;

import com.dharbor.set.social.services.common.annotation.SynchronousExecution;
import com.dharbor.set.social.services.common.core.CoreCommand;
import com.dharbor.set.social.services.test.restassured.RootTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author rveizaga
 */
@SynchronousExecution
public class CountExplanationCmd implements CoreCommand {

    private RootTest root;

    private Object counter;

    @Override
    public void onExecute() {
        Response response = root.request()
                .contentType(ContentType.JSON)
                .expect()
                .statusCode(200)
                .when()
                .get(root.getRegisterPath() + "/resources/" + root.getResourceId() + "/countExplanations");

        counter = response.as(Object.class);
    }

    public Object getCounter() {
        return counter;
    }

    public void setRoot(RootTest root) {
        this.root = root;
    }
}
