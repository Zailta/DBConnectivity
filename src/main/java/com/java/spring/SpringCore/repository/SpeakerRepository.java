package com.java.spring.SpringCore.repository;

import java.util.List;

import com.java.spring.SpringCore.model.Speaker;

public interface SpeakerRepository {
	 List <Speaker>findAll();
}
