package com.dharbor.set.social.services.common.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author rveizaga
 */
@Component
public class MethodTestChronometer {

    private ConcurrentMap<String, Long> startMap;

    private ConcurrentMap<String, Long> endMap;

    public void onStart(Class<?> clazz, Long time) {
        startMap.put(buildKey(clazz), time);
    }

    public void onEnd(Class<?> clazz, Long time) {
        endMap.put(buildKey(clazz), time);
    }

    public Long loadTime(String key) {
        if (!startMap.containsKey(key)) {
            return 0L;
        }

        if (!endMap.containsKey(key)) {
            return 0L;
        }

        Long start = startMap.get(key);
        Long end = endMap.get(key);

        return end - start;
    }

    private String buildKey(Class<?> clazz) {
        return clazz.getName();
    }

    @PostConstruct
    void onPostConstruct() {
        startMap = new ConcurrentHashMap<>();
        endMap = new ConcurrentHashMap<>();
    }
}
