package com.ollogicalsolutions.viptotrip.rest.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FlightsNotFoundException extends RuntimeException {
    public FlightsNotFoundException(String s) {
        super(s);
    }
}
