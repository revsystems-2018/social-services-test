package com.dharbor.set.social.services.test.explanations.rest;

import com.dharbor.set.social.services.application.domain.Explanation;
import com.dharbor.set.social.services.application.wrapper.ExplanationWrapper;
import com.dharbor.set.social.services.test.explanations.ExplanationsRootTest;
import com.dharbor.set.social.services.test.explanations.cmd.InitializeExplanationCmd;
import com.dharbor.set.social.services.test.restassured.CustomRuleTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rveizaga
 */
public class InitializeExplanationTest extends CustomRuleTest {

    @Autowired
    private ExplanationsRootTest explanationsRootTest;

    @Autowired
    private InitializeExplanationCmd command;

    @Before
    public void setUp() {
        explanationsRootTest.initialize();
    }

    @Test
    public void createResourceExplanationTest() {
        command.setRoot(explanationsRootTest);
        command.onExecute();
        ExplanationWrapper explanation = command.getExplanation();

        Assert.assertNotNull(explanation.getContent());
    }
}
