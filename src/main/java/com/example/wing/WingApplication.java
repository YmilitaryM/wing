package com.example.wing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.wing.mapper")
public class WingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WingApplication.class, args);
    }

}
