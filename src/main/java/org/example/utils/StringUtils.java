package org.example.utils;

import java.util.Random;

public class StringUtils {

    private StringUtils() {
    }

    private static final String DATA_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String genrateString(int lenght) {
        char[] text = new char[lenght];
        for (int i = 0; i < lenght; i++) {
            text[i] = DATA_SET.charAt(new Random().nextInt(DATA_SET.length()));
        }
        return new String(text);
    }
}
