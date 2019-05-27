package com.ib.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

	
	@Bean
	public MultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver
	      = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(5*5242880); // 25mb
	    return multipartResolver;
	}
}
