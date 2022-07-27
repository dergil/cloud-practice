package com.optimagrowth.license.model.exception;

public class EntryNotFoundException extends RuntimeException {

    public EntryNotFoundException(Class<?> clazz, long id) {
        super(String.format("Entity %s with id %d not found", clazz.getSimpleName(), id));
    }
}
