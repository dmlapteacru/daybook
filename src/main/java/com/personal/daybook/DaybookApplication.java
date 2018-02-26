package com.personal.daybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DaybookApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaybookApplication.class, args);
	}
}
