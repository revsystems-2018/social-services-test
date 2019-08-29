package com.dharbor.set.social.services.test.explanations.cmd;

import com.dharbor.set.social.services.application.request.ResourceRequest;
import com.dharbor.set.social.services.application.wrapper.ExplanationWrapper;
import com.dharbor.set.social.services.application.wrapper.ResourceExplanationRegistryWrapper;
import com.dharbor.set.social.services.common.annotation.PostExecute;
import com.dharbor.set.social.services.common.annotation.PreExecute;
import com.dharbor.set.social.services.common.annotation.SynchronousExecution;
import com.dharbor.set.social.services.common.core.CoreCommand;
import com.dharbor.set.social.services.test.config.Constants;
import com.dharbor.set.social.services.test.restassured.RootTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rveizaga
 */
@SynchronousExecution
public class InitializeExplanationCmd implements CoreCommand {

    private RootTest root;

    private ResourceRequest resourceRequest;

    private ExplanationWrapper explanation;

    @Override
    public void onExecute() {

        Response response = root.request()
                .contentType(ContentType.JSON)
                .body(resourceRequest)
                .expect()
                .statusCode(HttpServletResponse.SC_CREATED)
                .when()
                .post(root.getRegisterPath() + "/resources/" +
                        root.getResourceId() + "/explanations/initialize");

        explanation = response.as(ExplanationWrapper.class);
    }

    @PreExecute
    public void onPreExecute() {
        explanation = new ExplanationWrapper();
        resourceRequest = new ResourceRequest();
        List<ResourceExplanationRegistryWrapper> resources = new ArrayList<>();

        ResourceExplanationRegistryWrapper wrapper = new ResourceExplanationRegistryWrapper();
        wrapper.setResourceName(Constants.APP_RESOURCE_ID);
        wrapper.setResourceValue(Constants.nextAppResourceUUID());
        resources.add(wrapper);

        resourceRequest.setResources(resources);
    }

    public void setRoot(RootTest root) {
        this.root = root;
    }

    public ExplanationWrapper getExplanation() {
        return explanation;
    }
}
