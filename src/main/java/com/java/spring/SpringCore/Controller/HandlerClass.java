package com.java.spring.SpringCore.Controller;

import com.java.spring.SpringCore.service.SpeakerRepositoryService;
import com.java.spring.SpringCore.service.SpeakerService;

public class HandlerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpeakerService service = new SpeakerRepositoryService();
		System.out.println(service.findAll().get(0).getFirstName());

	}

}
