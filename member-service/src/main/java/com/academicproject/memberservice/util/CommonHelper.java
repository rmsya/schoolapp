package com.academicproject.memberservice.util;

public class CommonHelper {
    public static String generateId(String prefix) {
        return prefix + "_" + System.currentTimeMillis();
    }
}
