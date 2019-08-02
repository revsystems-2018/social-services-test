package com.dharbor.set.social.services.test.common;

import com.dharbor.set.social.services.test.chat.ChatRootTest;
import com.dharbor.set.social.services.test.config.ServerConfig;
import com.dharbor.set.social.services.test.documents.DocumentsRootTest;
import com.dharbor.set.social.services.test.explanations.ExplanationsRootTest;
import com.dharbor.set.social.services.test.identity.IdentityRootTest;
import com.dharbor.set.social.services.test.notifications.NotificationsRootTest;
import com.dharbor.set.social.services.test.restassured.RestAssuredAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author rveizaga
 */
@Configuration
public class serviceFactory {

    @Autowired
    private RestAssuredAdapter restAssuredAdapter;

    @Autowired
    private ServerConfig serverConfig;

    @Bean
    @Scope("prototype")
    public ExplanationsRootTest explanationsRootTest() {

        ExplanationsRootTestImpl instance = new ExplanationsRootTestImpl(serverConfig, restAssuredAdapter);

        instance.initialize();

        return instance;
    }

    @Bean
    @Scope("prototype")
    public ChatRootTest chatRootTest() {

        ChatRootTestImpl instance = new ChatRootTestImpl(serverConfig, restAssuredAdapter);

        instance.initialize();

        return instance;
    }

    @Bean
    @Scope("prototype")
    public DocumentsRootTest documentsRootTest() {

        DocumentsRootTestImpl instance = new DocumentsRootTestImpl(serverConfig, restAssuredAdapter);

        instance.initialize();

        return instance;
    }

    @Bean
    @Scope("prototype")
    public NotificationsRootTest notificationsRootTest() {

        NotificationsRootTestImpl instance = new NotificationsRootTestImpl(serverConfig, restAssuredAdapter);

        instance.initialize();

        return instance;
    }

    @Bean
    @Scope("prototype")
    public IdentityRootTest identityRootTest() {

        IdentityRootTestImpl instance = new IdentityRootTestImpl(serverConfig, restAssuredAdapter);

        instance.initialize();

        return instance;
    }
}
