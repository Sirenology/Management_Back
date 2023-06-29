package com.example.management_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.management_backend.mappers")
public class ManagementBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementBackendApplication.class, args);
    }

}
