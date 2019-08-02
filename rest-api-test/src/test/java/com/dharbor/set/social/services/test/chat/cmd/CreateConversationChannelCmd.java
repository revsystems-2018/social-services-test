package com.dharbor.set.social.services.test.chat.cmd;

import com.dharbor.set.social.services.application.request.ChatChannelRequest;
import com.dharbor.set.social.services.common.annotation.PreExecute;
import com.dharbor.set.social.services.common.annotation.SynchronousExecution;
import com.dharbor.set.social.services.common.core.CoreCommand;
import com.dharbor.set.social.services.test.chat.config.ConstantsChat;
import com.dharbor.set.social.services.test.restassured.RootTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

/**
 * @author rveizaga
 */
@SynchronousExecution
public class CreateConversationChannelCmd implements CoreCommand {

    private RootTest root;

    private ChatChannelRequest channelRequest;

    private Object object;

    private Integer codeResponse;

    @Override
    public void onExecute() {

        Response response = root.request()
                .contentType(ContentType.JSON)
                .body(channelRequest)
                .expect()
                .statusCode(200)
                .when()
                .post(root.getRegisterPath() + "/conversationChannels");

        object = response.as(Object.class);
        codeResponse = response.getStatusCode();
    }

    @PreExecute
    void onPreExecute() {
        List<String> userIds;
        channelRequest = new ChatChannelRequest();

        userIds = ConstantsChat.nextUserIds(3);
        channelRequest.setLabel(ConstantsChat.LABEL);
        channelRequest.setDescription(ConstantsChat.DESCRIPTION);
        channelRequest.setUserIds(userIds);
    }

    public Object getObject() {
        return object;
    }

    public Integer getCodeResponse() {
        return codeResponse;
    }

    public void setRoot(RootTest root) {
        this.root = root;
    }
}
