package com.ecommerce.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.ecommerce.order.repository")
@EnableMongoAuditing
public class ECommerceApp
{

	public static void main(String[] args)
	{
		SpringApplication.run(ECommerceApp.class, args);
	}

}