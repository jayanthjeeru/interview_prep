package com.wipro.vaish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WhatsappApplication {
	static ApplicationContext context = null;
	public static void main(String[] args) {
		 context = SpringApplication.run(WhatsappApplication.class, args);
	}

}
