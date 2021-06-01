package com.rest.webservice.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("user")
@ComponentScan("Filtering")
@ComponentScan("HelloWorld")
@ComponentScan("Exception")
@ComponentScan("Versioning")
public class WebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceApplication.class, args);
	}

}
