package com.java.spring.SpringCore.service;

import java.util.List;

import com.java.spring.SpringCore.model.Speaker;
import com.java.spring.SpringCore.repository.SpeakerRepository;
import com.java.spring.SpringCore.repository.SpeakerRepositoryImpl;

public class SpeakerRepositoryService implements SpeakerService {
	SpeakerRepository repository;
	@Override
	public List <Speaker>findAll(){
		return repository.findAll();
	}

	public void setRepository(SpeakerRepository repository) {
		this.repository = repository;
	}
	
}
