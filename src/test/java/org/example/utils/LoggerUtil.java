package org.example.utils;

public class LoggerUtil {
    public static org.apache.log4j.Logger getLogger(Class<?> clazz) {
        return org.apache.log4j.Logger.getLogger(clazz);
    }
}
