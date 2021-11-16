package com.independent.gz;

import org.apache.logging.log4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Main {

	private static final Logger logger = LogManager.getLogger(Main.class.getName());



	/**
	 * Main method. Startup the Spring application with given args
	 *
	 * @param args arguments to be passed to spring (none expected)
	 */
	public static void main(String[] args) {
		logger.info("-- booting up application --");
		SpringApplication.run(Main.class, args);
	}

	/**
	 * @see https://spring.io/guides/gs/rest-service-cors/
	 *
	 * @return the configurer that check incoming origins for CORS purposes
	 */
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
						.allowedOrigins("http://localhost:9500");
				//.allowedOrigins("http://localhost:9500", "https://csse-s302g12.canterbury.ac.nz");
			}
		};
	}

}
