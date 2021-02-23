package com.gruppo.isc.extranet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExtranetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtranetApplication.class, args);
	}

}
