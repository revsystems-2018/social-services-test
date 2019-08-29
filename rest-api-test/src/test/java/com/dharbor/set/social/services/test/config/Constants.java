package com.dharbor.set.social.services.test.config;

/**
 * @author rveizaga
 */
public class Constants {

    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String APP_RESOURCE_ID = "appResourceId";

    public static String nextResourceId() {
        int index = (int) (Math.random() * 5);

        if (index == 3) {
            return "-" + numberGenerator() + "_" + numberGenerator();
        }
        return numberGenerator() + "_" + numberGenerator();
    }

    public static String nextAppResourceUUID() {
        return numberLetterGenerator(8) + "-" +
                numberLetterGenerator(4) + "-" +
                numberLetterGenerator(4) + "-" +
                numberLetterGenerator(4) + "-" +
                numberLetterGenerator(12);
    }

    private static String numberGenerator() {
        String result = "";
        String[] list = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < 10; i++) {
            int index = (int) (Math.random() * 10);
            if (i == 0 && index == 0) {
                result = result + "1";
            } else {
                result = result.concat(list[index]);
            }
        }
        return result;
    }

    private static String numberLetterGenerator(int size) {
        String result = "";
        String[] list = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        for (int i = 0; i < size; i++) {
            int index = (int) (Math.random() * 16);
            result = result.concat(list[index]);
        }
        return result;
    }
}
