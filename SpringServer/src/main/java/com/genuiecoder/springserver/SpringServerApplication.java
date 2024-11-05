package com.genuiecoder.springserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.genuiecoder.springserver")
@EnableAutoConfiguration
public class SpringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServerApplication.class, args);
	}

}
