package com.amcef.assignment.apiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;





//Worth to mention that everytime you restart the app it will delete the database,
// because its using h2 in memory database....



@SpringBootApplication
@EnableFeignClients
public class ApiApp {

	public static void main(String[] args) {
		SpringApplication.run(ApiApp.class, args);
	}

}
