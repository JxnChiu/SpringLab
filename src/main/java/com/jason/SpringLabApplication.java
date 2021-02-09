package com.jason;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan
@EntityScan
@SpringBootApplication // @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
public class SpringLabApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringLabApplication.class, args);
	}
}
