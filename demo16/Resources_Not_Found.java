package com.somesh.web.demo16;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Resources_Not_Found extends RuntimeException{
    public Resources_Not_Found(String s) {
        super(s);
    }
}
