package com.dharbor.set.social.services.test.restassured;

import org.junit.ClassRule;
import org.junit.Rule;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

/**
 * @author rveizaga
 */

@ContextConfiguration(
        classes = {
                com.dharbor.set.social.services.test.Config.class
        }
)
@TestPropertySource(locations = "/application.properties")
public abstract class CustomRuleTest {

    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();
}
