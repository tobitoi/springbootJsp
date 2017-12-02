package com.attendance;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@EnableBatchProcessing
@SpringBootApplication
@ComponentScan({"com.attendance", "controller", "service"})
public class Application {
 
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
