package org.example.utils;

import java.util.Random;

public class StringUtils {

    private StringUtils() {
    }

    private static final String DATA_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateAlphanumericString(int length) {
        return getString(length, DATA_SET);
    }

    public static String generateAlphabeticalString(int length) {
        return getString(length, DATA_SET.substring(0, DATA_SET.length() - 10));
    }

    public static String generateNinesString(int length) {
        return getString(length, "9");
    }

    private static String getString(int length, String dataSet) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = dataSet.charAt(new Random().nextInt(dataSet.length()));
        }
        return new String(text);
    }
}
