package com.dharbor.set.social.services.test.chat.rest;

import com.dharbor.set.social.services.test.chat.ChatRootTest;
import com.dharbor.set.social.services.test.chat.cmd.CreateConversationChannelCmd;
import com.dharbor.set.social.services.test.restassured.CustomRuleTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;

/**
 * @author rveizaga
 */
public class CreateConversationChannelTest extends CustomRuleTest {

    @Autowired
    private ChatRootTest chatRootTest;

    @Autowired
    private CreateConversationChannelCmd command;

    @Before
    public void setUp() {
        chatRootTest.initialize();
    }

    @Test
    public void CreateChannelTest() {
        command.setRoot(chatRootTest);
        command.onExecute();
        Object object = command.getObject();
        int code = command.getCodeResponse();

        Assert.assertNotNull(object);
        Assert.assertEquals(HttpServletResponse.SC_OK, code);
    }
}
