package com.dharbor.set.social.services.test.identity.rest;

import com.dharbor.set.social.identity.data.domain.User;
import com.dharbor.set.social.services.test.identity.IdentityRootTest;
import com.dharbor.set.social.services.test.identity.cmd.FindUserIdentityCmd;
import com.dharbor.set.social.services.test.restassured.CustomRuleTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rveizaga
 */
public class FindUserIdentityTest extends CustomRuleTest {

    @Autowired
    private IdentityRootTest identityRootTest;

    @Autowired
    private FindUserIdentityCmd command;

    @Before
    public void setUp() {
        identityRootTest.initialize();
    }

    @Test
    public void findUserByUserIdTest() {
        command.setRoot(identityRootTest);
        command.onExecute();
        User user = command.getUser();

        Assert.assertNotNull(user.getId());
    }
}
