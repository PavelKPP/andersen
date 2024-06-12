package com.ticketservice.annotation;

import java.lang.reflect.Field;

public class NullableWarningAnnotation {

    public static void checkFieldsForNull(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i] == null) {
                System.out.println("Variable " + fields[i] + " is null in Class " + object.getClass());
            }
        }
    }
}
