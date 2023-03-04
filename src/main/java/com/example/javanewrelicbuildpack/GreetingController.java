package com.example.javanewrelicbuildpack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {

    @GetMapping("/greeting")
    String hello() {
        return "Hello World!";
    }
}
