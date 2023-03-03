package com.java.databases.JPA;

import java.util.Random;

public class GateGenerator {
	private String gateId;

	public GateGenerator() {
		super();
		String gateId = hashCodeGenerator();
		setGateId(gateId);
		// TODO Auto-generated constructor stub
	}

	public String getGateId() {
		return gateId;
	}

	public void setGateId(String gateId) {
		this.gateId = gateId;
	}
	
	public static String hashCodeGenerator() {
	    int leftLimit = 65; // letter 'a'
	    int rightLimit = 72; // letter 'z'
	    int targetStringLength = 1;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    String  randomNumber = Integer.toString((int)(new Random().nextInt(9)+1));

	    //System.out.println(randomNumber+generatedString);
	    return randomNumber+generatedString;
	}
}
