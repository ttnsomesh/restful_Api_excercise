package com.somesh.web.demo15;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootHandler {

    @GetMapping(path = "/springs")
    public SpringBoot springMethod(){
        return new SpringBoot("welcome to spring boot");
    }


}
