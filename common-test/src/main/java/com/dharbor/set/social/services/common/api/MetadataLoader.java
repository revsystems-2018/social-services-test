package com.dharbor.set.social.services.common.api;

import com.dharbor.set.social.services.common.annotation.PostExecute;
import com.dharbor.set.social.services.common.annotation.PreExecute;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author rveizaga
 */
public abstract class MetadataLoader {

    private Method preExecuteMethod;

    private Method postExecuteMethod;

    public void process() {
        Object commandInstance = getCommandInstance();

        ReflectionUtils.doWithMethods(commandInstance.getClass(), method -> {
            if (method.isAnnotationPresent(PreExecute.class)) {
                preExecuteMethod = method;
            }

            if (method.isAnnotationPresent(PostExecute.class)) {
                postExecuteMethod = method;
            }
        });
    }

    protected abstract Object getCommandInstance();

    public Method getPreExecuteMethod() {
        return preExecuteMethod;
    }

    public Method getPostExecuteMethod() {
        return postExecuteMethod;
    }
}
