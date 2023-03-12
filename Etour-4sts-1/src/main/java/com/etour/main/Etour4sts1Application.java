package com.etour.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.*")
@ComponentScan(basePackages="com.*")
@EntityScan(basePackages="com.etour.*")
@EnableJpaRepositories(basePackages="com.*")
public class Etour4sts1Application {

	public static void main(String[] args) {
		SpringApplication.run(Etour4sts1Application.class, args);
	}

}
