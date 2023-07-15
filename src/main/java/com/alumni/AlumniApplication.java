package com.alumni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class AlumniApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
        String seed="w7A&e5LpUs8FxEv2FaBR";
        return new BCryptPasswordEncoder(10, new SecureRandom(seed.getBytes(StandardCharsets.UTF_8)));
	}




	public static void main(String[] args) {
		SpringApplication.run(AlumniApplication.class, args);
	}

}
