package com.java.databases.JPA;

import java.util.Random;

public class FlightGenerator {
	private String flightId;

	public FlightGenerator() {
		super();
		setFlightId();
		// TODO Auto-generated constructor stub
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId() {
		this.flightId = hashCodeGenerator();
	}
	
	public static String hashCodeGenerator() {
	    int leftLimit = 65; // letter 'a'
	    int rightLimit = 90; // letter 'z'
	    int targetStringLength = 3;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    String  randomNumber = Integer.toString((int)(new Random().nextInt(9999)+1));

	    System.out.println(generatedString+randomNumber);
	    return generatedString+randomNumber;
	}
}
