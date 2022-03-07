package com.somesh.web.demo15;
/*
Create a simple REST ful service in Spring Boot which returns the Response "Welcome to spring boot".
 */
public class SpringBoot {
    private String message;

    public SpringBoot(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SpringBoot{" +
                "message='" + message + '\'' +
                '}';
    }
}
