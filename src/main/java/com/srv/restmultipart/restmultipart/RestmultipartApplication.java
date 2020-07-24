package com.srv.restmultipart.restmultipart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.srv.restmultipart")
public class RestmultipartApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestmultipartApplication.class, args);
	}

}
