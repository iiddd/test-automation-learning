package org.example.utils;

public class CompareWithoutHyphens {
    public static boolean compareIgnoringHyphens(String string1, String string2) {
        if (string1 == null || string2 == null) {
            return false;
        }
        String normalizedString1 = string1.replace("-", "");
        String normalizedString2 = string2.replace("-", "");
        return normalizedString1.equals(normalizedString2);
    }
}
