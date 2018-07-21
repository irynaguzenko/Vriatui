package com.testname.vriatui.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String objectId) {
        super("Object with id " + objectId + " is not found");
    }

    public ObjectNotFoundException() {
    }
}
