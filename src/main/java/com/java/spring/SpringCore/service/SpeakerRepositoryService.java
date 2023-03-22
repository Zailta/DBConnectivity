package com.java.spring.SpringCore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.SpringCore.model.Speaker;
import com.java.spring.SpringCore.repository.SpeakerRepository;
import com.java.spring.SpringCore.repository.SpeakerRepositoryImpl;
@Service
public class SpeakerRepositoryService implements SpeakerService {
	@Autowired
	SpeakerRepository repository;

	/*
	 * public SpeakerRepositoryService (SpeakerRepository repository) {
	 * this.repository = repository; }
	 */	@Override
	public List <Speaker>findAll(){
		return repository.findAll();
	}

	
	public void setRepository(SpeakerRepository repository) {
		this.repository = repository;
	}
	
}
