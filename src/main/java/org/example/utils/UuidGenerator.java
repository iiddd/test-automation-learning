package org.example.utils;

import java.util.UUID;

public class UuidGenerator {
    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
