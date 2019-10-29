package com.giri.studyapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.giri.studyapplication.repositoryCfg.RepositoryCfg;
import com.giri.studyapplication.security.cfg.SpringSecurityCfgBasic;

@Import({RepositoryCfg.class,SpringSecurityCfgBasic.class })
@ComponentScan(basePackages = { "com.giri.studyapplication.controllercfg",
		"com.giri.studyapplication.repositoryCfg.materialDAO" })
@SpringBootApplication
public class StudyapplicationApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(StudyapplicationApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudyapplicationApplication.class);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/material").allowedOrigins("http://localhost:3000");
				registry.addMapping("/bannerdetai").allowedOrigins("http://localhost:3000");
			}
		};
	}

	/// Studyapplication/src/main/resources/frontend
}
