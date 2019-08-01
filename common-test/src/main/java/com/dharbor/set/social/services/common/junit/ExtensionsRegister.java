package com.dharbor.set.social.services.common.junit;

import com.dharbor.set.social.services.common.annotation.EnableJUnitExtensions;
import com.dharbor.set.social.services.common.annotation.ExecutionPriority;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;

import java.util.Set;

/**
 * @author rveizaga
 */
public class ExtensionsRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
                                        BeanDefinitionRegistry beanDefinitionRegistry) {

        String packagesToScan = annotationMetadata
                .getAnnotationAttributes(EnableJUnitExtensions.class.getName())
                .get("value")
                .toString();

        processTestClass(packagesToScan);
    }

    private void processTestClass(String context) {
        ClassPathScanningCandidateComponentProvider scanner = scannerProvider();

        Set<BeanDefinition> components = scanner.findCandidateComponents(context);

        for (BeanDefinition component : components) {
            Class<?> aClazz = ClassUtils.resolveClassName(
                    component.getBeanClassName(),
                    ClassUtils.getDefaultClassLoader());

/*            if (!ClassUtils.isAssignable(AbstractTest.class, aClazz)) {
                continue;
            }*/

            if (aClazz.isAnnotationPresent(ExecutionPriority.class)) {
                ExecutionPriority annotation = AnnotationUtils.findAnnotation(aClazz, ExecutionPriority.class);

                StoreClass.getInstance().register(annotation, aClazz);

                continue;
            }

            StoreClass.getInstance().register(aClazz);
        }

    }

    private ClassPathScanningCandidateComponentProvider scannerProvider() {
        ClassPathScanningCandidateComponentProvider result = new ClassPathScanningCandidateComponentProvider(true);
        /*result.addIncludeFilter(new AssignableTypeFilter(AbstractTest.class));*/

        return result;
    }
}
