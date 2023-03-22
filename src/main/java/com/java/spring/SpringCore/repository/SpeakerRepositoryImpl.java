package com.java.spring.SpringCore.repository;
import java.util.*;
import com.java.spring.SpringCore.model.Speaker;

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
