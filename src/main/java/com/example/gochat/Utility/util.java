package com.example.gochat.Utility;

import java.util.Random;

public class util {

    public static Integer Int(String s) {
        return Integer.parseInt(s);
    }

    public static Long Long(String s) {
        return Long.parseLong(s);
    }

    public static String RandomCode() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(new Random().nextInt(10));
        }
        return stringBuilder.toString();
    }

}
