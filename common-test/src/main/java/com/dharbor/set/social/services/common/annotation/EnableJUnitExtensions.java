package com.dharbor.set.social.services.common.annotation;

import com.dharbor.set.social.services.common.junit.ExtensionsRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author rveizaga
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ExtensionsRegister.class)
public @interface EnableJUnitExtensions {

    String value();
}
