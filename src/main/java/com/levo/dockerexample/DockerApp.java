package com.levo.dockerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.levo.dockerexample"})
public class DockerApp {
    public static void main(String[] args) {
        SpringApplication.run(DockerApp.class, args);
    }
}
