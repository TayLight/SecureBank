package com.securebank.securebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({
		"com.securebank.securebank","com.securebank.securebank.controller"
})
@EntityScan(basePackages = "com.securebank.securebank")
@EnableJpaRepositories(basePackages = "com.securebank.securebank")
public class SecurebankApplication {



	public static void main(String[] args) {
		SpringApplication.run(SecurebankApplication.class, args);
	}

}
