package com.dharbor.set.social.services.common.api;

import com.dharbor.set.social.services.common.annotation.AsynchronousExecution;
import com.dharbor.set.social.services.common.annotation.SynchronousExecution;
import com.dharbor.set.social.services.common.exception.HandledBusinessLogicException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author rveizaga
 */
@Aspect
@Component
public class BLCmdExecuteMethodInterceptor implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(BLCmdExecuteMethodInterceptor.class);

    private ApplicationContext applicationContext;

    @Around("within(com.dharbor.set.social.services.common.core.CoreCommand+) && execution(public void onExecute())")
    public void executeMethodAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object commandInstance = joinPoint.getTarget();

        LOGGER.debug("Executing CoreCommand: '" + commandInstance.getClass() + "'");

        Class<? extends CommandExecutorService> executorServiceClazz = loadExecutorServiceClazz(commandInstance);

        CommandExecutorService service = applicationContext.getBean(executorServiceClazz);

        MetadataLoader metadata = new MetadataLoader() {
            @Override
            protected Object getCommandInstance() {
                return commandInstance;
            }
        };

        metadata.process();

        try {
            service.onExecute(new Work() {
                @Override
                protected void proceed() throws Throwable {
                    joinPoint.proceed();
                }

                @Override
                protected void preProceed() throws Throwable {
                    if (null != metadata.getPreExecuteMethod()) {
                        Method preExecute = metadata.getPreExecuteMethod();

                        ReflectionUtils.makeAccessible(preExecute);
                        ReflectionUtils.invokeMethod(preExecute, commandInstance);
                    }
                }

                @Override
                protected void postProceed() throws Throwable {
                    if (null != metadata.getPostExecuteMethod()) {
                        Method postExecute = metadata.getPostExecuteMethod();

                        ReflectionUtils.makeAccessible(postExecute);
                        ReflectionUtils.invokeMethod(postExecute, commandInstance);
                    }
                }
            });
        } catch (Throwable throwable) {
            if (throwable instanceof HandledBusinessLogicException) {
                throw ((HandledBusinessLogicException) throwable).getSource();
            }

            throw throwable;
        }
    }

    private Class<? extends CommandExecutorService> loadExecutorServiceClazz(Object commandInstance) {
        if (commandInstance.getClass().isAnnotationPresent(SynchronousExecution.class)) {
            return SynchronousExecutionService.class;
        }

        if (commandInstance.getClass().isAnnotationPresent(AsynchronousExecution.class)) {
            return AsynchronousExecutionService.class;
        }

        throw new UnsupportedOperationException("Command execution strategy is not defined, the command class '"
                + commandInstance.getClass()
                + "' must ne annotated  with @SynchronousExecution or @AsynchronousExecution");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
