package com.m2i.biblioSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class BiblioSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiblioSpringBootApplication.class, args);
	}
}
