package com.julien.juge.khast.api;

import com.julien.juge.khast.api.config.mvc.WebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
public class KhastApplication {

	@Bean
	public WebMvcConfigurerAdapter rxJavaWebMvcConfiguration() {
		return new WebMvcConfiguration();
	}

	public static void main(String[] args) {
		SpringApplication.run(KhastApplication.class, args);
	}
}
