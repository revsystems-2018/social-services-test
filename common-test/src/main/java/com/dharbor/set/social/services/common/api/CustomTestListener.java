package com.dharbor.set.social.services.common.api;

import com.dharbor.set.social.services.common.model.MethodTestChronometer;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;


/**
 * @author rveizaga
 */
public class CustomTestListener implements TestExecutionListener {

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        MethodTestChronometer chronometer = testContext.getApplicationContext().getBean(MethodTestChronometer.class);
        chronometer.onStart(testContext.getTestClass(), System.currentTimeMillis());
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        MethodTestChronometer chronometer = testContext.getApplicationContext().getBean(MethodTestChronometer.class);
        chronometer.onEnd(testContext.getTestClass(), System.currentTimeMillis());
    }
}
