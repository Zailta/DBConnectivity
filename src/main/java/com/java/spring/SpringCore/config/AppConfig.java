package com.java.spring.SpringCore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.java.spring.SpringCore.repository.SpeakerRepository;
import com.java.spring.SpringCore.repository.SpeakerRepositoryImpl;
import com.java.spring.SpringCore.service.SpeakerRepositoryService;
import com.java.spring.SpringCore.service.SpeakerService;

@Configuration
public class AppConfig {
	
	@Bean(name = "speakerService")
	public SpeakerService getSpeakerService() {
		SpeakerRepositoryService service = new SpeakerRepositoryService();
				service.setRepository(getSpeakerRepository());
		return service;
	}
	
	@Bean(name = "speakerRepository")
	public SpeakerRepository getSpeakerRepository() {
		return new SpeakerRepositoryImpl();
	}

}
