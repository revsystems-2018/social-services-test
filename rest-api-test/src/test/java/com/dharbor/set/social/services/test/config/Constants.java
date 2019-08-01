package com.dharbor.set.social.services.test.config;

/**
 * @author rveizaga
 */
public class Constants {

    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String APP_RESOURCE_ID = "appResourceId";
    public static final String RESOURCE_UUID = "resourceUUID";

    public static String nextResourceId() {
        int aux = (int) (Math.random() * 5);
        if (aux == 3) {
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
        String res = "";
        String[] list = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < 10; i++) {
            int aux = (int) (Math.random() * 10);
            if (i == 0 && aux == 0) {
                res = res + "1";
            } else {
                res = res.concat(list[aux]);
            }
        }
        return res;
    }

    private static String numberLetterGenerator(int size) {
        String res = "";
        String[] list = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

        for (int i = 0; i < size; i++) {
            int aux = (int) (Math.random() * 16);
            res = res.concat(list[aux]);
        }
        return res;
    }
}
