package com.shrimp.util;

/**
 * @description:
 * @author: shrimp
 * @date: Created in 2020-01-11 17:40
 * @version: 1.0
 */
public class AssertUtil {
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);

        }
    }
}
