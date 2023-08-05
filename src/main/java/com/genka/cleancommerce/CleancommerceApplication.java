package com.genka.cleancommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CleancommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleancommerceApplication.class, args);
	}

}
