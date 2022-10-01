package com.management.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class RestProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestProductsApplication.class, args);
	}

}
