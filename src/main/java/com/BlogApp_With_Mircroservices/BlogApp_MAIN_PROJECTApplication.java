package com.BlogApp_With_Mircroservices;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.PasswordAuthentication;

@SpringBootApplication
@EnableSwagger2
public class BlogApp_MAIN_PROJECTApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApp_MAIN_PROJECTApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return  new ModelMapper();
	}

	@Bean
	public PasswordEncoder getPasswordEncode(){
		return  new BCryptPasswordEncoder();

	}


}
