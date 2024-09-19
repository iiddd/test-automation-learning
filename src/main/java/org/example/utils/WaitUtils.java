package org.example.utils;

public class WaitUtils {

    public static void dummyWait(long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
