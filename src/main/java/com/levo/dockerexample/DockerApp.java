package com.levo.dockerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class DockerApp {
	public static void main(String[] args) {
		SpringApplication.run(DockerApp.class, args);
	}
}
