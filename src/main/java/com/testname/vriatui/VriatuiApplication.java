package com.testname.vriatui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class VriatuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VriatuiApplication.class, args);
    }

    @GetMapping
    public String hello() {
        return "<h1>Vriatui</h1><br/><h2>Made by: Bohdan Zhukovetskii, Iryna Ziabkina, Alexey Ziabkin</h2>";
    }
}
