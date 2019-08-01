package com.dharbor.set.social.services.common.annotation;

import com.dharbor.set.social.services.common.enums.ExecutionLevel;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rveizaga
 */
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExecutionPriority {

    ExecutionLevel value();
}
