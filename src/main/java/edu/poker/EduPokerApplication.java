package edu.poker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring boot application exposing cards solution through rest API running on http://localhost:8080/
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "edu.poker.config", "edu.poker.api", "edu.poker.model"})
public class EduPokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduPokerApplication.class, args);
	}

}
