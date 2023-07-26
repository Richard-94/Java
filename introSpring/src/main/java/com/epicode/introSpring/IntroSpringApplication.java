package com.epicode.introSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.epicode") // Adjust the base package name accordingly
public class IntroSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntroSpringApplication.class, args);
    }

}
