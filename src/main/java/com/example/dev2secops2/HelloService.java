package com.example.dev2secops2;
import org.springframework.web.bind.annotation.*;
@RestController
public class HelloService {
    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}