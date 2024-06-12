package com.ticketservice.validators;

public class IdValidator {

    public static Long validateId(Long id) {
        if (id / 1000 > 9) {
            throw new IllegalArgumentException("id should be less than 4 digits");
        } else {
            System.out.println("id is valid!");
            return id;
        }
    }
}
