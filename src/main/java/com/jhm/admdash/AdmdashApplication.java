package com.jhm.admdash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jhm.admdash")
public class AdmdashApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmdashApplication.class, args);
	}

}
