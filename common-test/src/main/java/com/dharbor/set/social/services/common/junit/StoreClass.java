package com.dharbor.set.social.services.common.junit;

import com.dharbor.set.social.services.common.annotation.ExecutionPriority;
import com.dharbor.set.social.services.common.enums.ExecutionLevel;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author rveizaga
 */
public final class StoreClass {

    private static StoreClass instance;

    private ConcurrentMap<ExecutionLevel, List<Class<?>>> annotatedTestCases;

    private List<Class<?>> defaultTestCases;

    private StoreClass() {
        instance = null;
        annotatedTestCases = new ConcurrentHashMap<>();
        defaultTestCases = new ArrayList<>();
    }

    public static StoreClass getInstance() {
        if (null == instance) {
            instance = new StoreClass();
        }

        return instance;
    }

    public void register(ExecutionPriority annotation, Class<?> clazz) {
        ExecutionLevel executionLevel = annotation.value();

        if (!annotatedTestCases.containsKey(executionLevel)) {
            annotatedTestCases.put(executionLevel, new LinkedList<>());
        }

        List<Class<?>> elements = annotatedTestCases.get(executionLevel);

        elements.add(clazz);

        annotatedTestCases.put(executionLevel, elements);
    }

    public void register(Class<?> clazz) {
        defaultTestCases.add(clazz);
    }

    public LinkedList<Class<?>> values() {
        LinkedList<Class<?>> elements = new LinkedList<>();

        for (ExecutionLevel level : ExecutionLevel.values()) {
            List<Class<?>> testCases = annotatedTestCases.get(level);

            if (CollectionUtils.isEmpty(testCases)) {
                continue;
            }

            elements.addAll(testCases);
        }

        elements.addAll(defaultTestCases);

        return elements;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("A singleton cannot be cloned.");
    }
}
