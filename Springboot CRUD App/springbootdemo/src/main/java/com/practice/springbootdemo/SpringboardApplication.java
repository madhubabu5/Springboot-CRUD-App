package com.practice.springbootdemo;

import com.practice.springbootdemo.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringboardApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringboardApplication.class, args);
	}
}
