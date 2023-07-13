package com.isource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
@EnableCaching
public class T247ApiAnalyticsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(T247ApiAnalyticsApplication.class, args);

		System.out.println("T247-Api-Analytics");
		
		long heapSize = Runtime.getRuntime().totalMemory();
		long heapMaxSize = Runtime.getRuntime().maxMemory();
		long heapFreeSize = Runtime.getRuntime().freeMemory();
		System.out.println("heapSize     : " + heapSize);
		System.out.println("heapMaxSize  : " + heapMaxSize);
		System.out.println("heapFreeSize : " + heapFreeSize);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(T247ApiAnalyticsApplication.class);
	}
}
