package com.dharbor.set.social.services.test.explanations.rest;

import com.dharbor.set.social.services.test.explanations.ExplanationsRootTest;
import com.dharbor.set.social.services.test.explanations.cmd.CountExplanationCmd;
import com.dharbor.set.social.services.test.restassured.CustomRuleTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rveizaga
 */
public class CountExplanationTest extends CustomRuleTest {

    @Autowired
    private ExplanationsRootTest explanationsRootTest;

    @Autowired
    private CountExplanationCmd command;

    @Before
    public void initializeExplanation() {
        explanationsRootTest.initialize();
    }

    @Test
    public void counterExplanationTest() {
        command.setRoot(explanationsRootTest);
        command.onExecute();

        Object counter = command.getCounter();

        Assert.assertNotNull(counter);
    }
}
