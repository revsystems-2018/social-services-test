package com.dharbor.set.social.services.test.chat.config;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author rveizaga
 */
public class ConstantsChat {

    public static final String LABEL = "Set-BO";
    public static final String DESCRIPTION = "Set-BO Team";

    public static List<String> nextUserIds(int size) {
        return IntStream.range(0, size).mapToObj(i -> userIdGenerator(8)).collect(Collectors.toList());
    }

    private static String userIdGenerator(int size) {
        String result = "";
        String[] list = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "a", "b", "c", "d", "e", "f",
                "A", "B", "C", "D", "E", "F"};

        for (int i = 0; i < size; i++) {
            int index = (int) (Math.random() * 22);
            result = result.concat(list[index]);
        }
        return result;
    }
}
