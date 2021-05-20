package com.bitcollege.knowledgecybersecuritywebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class KnowledgeCybersecurityWebServiceApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KnowledgeCybersecurityWebServiceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(KnowledgeCybersecurityWebServiceApplication.class, args);
	}

}
