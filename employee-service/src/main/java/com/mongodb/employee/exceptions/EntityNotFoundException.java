package com.mongodb.employee.exceptions;

import java.util.Arrays;

public class EntityNotFoundException extends RuntimeException {
    private final String[] args;

    public EntityNotFoundException(String... args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "EntityNotFoundException " + Arrays.toString(args);
    }

}
