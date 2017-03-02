package com.stanfieldsystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class ChaosApplication {

	public static void main(String[] args) {
		
		
		System.out.println("###################################################");
		System.out.println("           CHAOS APPLICATION STARTED               ");
		System.out.println("###################################################");
		SpringApplication.run(ChaosApplication.class, args);
	}
}
