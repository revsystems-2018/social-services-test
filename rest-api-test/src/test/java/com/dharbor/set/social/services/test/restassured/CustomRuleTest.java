package com.dharbor.set.social.services.test.restassured;

import com.dharbor.set.social.services.common.api.CustomTestListener;
import org.junit.ClassRule;
import org.junit.Rule;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import static org.springframework.test.context.TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS;

/**
 * @author rveizaga
 */

@ContextConfiguration(
        classes = {
                com.dharbor.set.social.services.test.Config.class
        }
)
@TestPropertySource(locations = "/application.properties")
/*@TestExecutionListeners(
        listeners = {
                CustomTestListener.class
        },
        mergeMode = MERGE_WITH_DEFAULTS
)*/
public abstract class CustomRuleTest {

    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();
}
