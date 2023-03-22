package com.java.spring.SpringCore.repository;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.java.spring.SpringCore.model.Speaker;

@Repository
public class SpeakerRepositoryImpl implements SpeakerRepository{
	
	public List <Speaker>findAll(){
	
	List <Speaker>speakerList = new ArrayList<>();
	
	Speaker speaker = new Speaker();
	speaker.setFirstName("Mohammad");
	speaker.setLastName("Bhat");
	speakerList.add(speaker);
	
	return speakerList;
	}

}
