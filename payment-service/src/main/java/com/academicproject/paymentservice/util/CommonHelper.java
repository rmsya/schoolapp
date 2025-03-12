package com.academicproject.paymentservice.util;

public class CommonHelper {
    public static String generateId(String prefix) {
        return prefix + "_" + System.currentTimeMillis();
    }
}
