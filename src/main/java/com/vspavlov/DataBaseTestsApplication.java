package com.vspavlov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.vspavlov.*")
public class DataBaseTestsApplication {



    public static void main(String[] args) {
        SpringApplication.run(DataBaseTestsApplication.class, args);
    }
}
