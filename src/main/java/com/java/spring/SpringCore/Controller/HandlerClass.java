package com.java.spring.SpringCore.Controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.spring.SpringCore.config.AppConfig;
import com.java.spring.SpringCore.service.SpeakerService;

public class HandlerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		SpeakerService service = applicationContext.getBean(SpeakerService.class);
		System.out.println(service.findAll().get(0).getFirstName());

	}

}
