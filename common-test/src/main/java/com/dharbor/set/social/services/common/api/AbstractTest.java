package com.dharbor.set.social.services.common.api;

import org.junit.ClassRule;
import org.junit.Rule;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import java.util.Random;

/**
 * @author rveizaga
 */
public abstract class AbstractTest {

    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    protected void sleep() {
        try {
            long millis = (long) new Random().nextInt(4500 - 3000 + 1) + 3000;
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new UnsupportedOperationException("Unable to activate sleep timer ", e);
        }
    }
}
