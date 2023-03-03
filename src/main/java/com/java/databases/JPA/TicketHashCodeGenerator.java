package com.java.databases.JPA;

import java.io.Serializable;
import java.util.Random;

import jakarta.persistence.Embeddable;
@Embeddable
public class TicketHashCodeGenerator implements Serializable {
	
	public TicketHashCodeGenerator(){
		super();
		String TicketHashCode = hashCodeGenerator();
		setTicketCode(TicketHashCode);
	}

	private String ticketCode ;
 
	public TicketHashCodeGenerator(String ticketCode) {
		super();
		this.ticketCode = ticketCode;
	}
	public String getTicketCode() {
		return ticketCode;
	}
	public void setTicketCode(String ticketCode) {
		this.ticketCode = ticketCode;
	}
	
	public static String hashCodeGenerator() {
	    int leftLimit = 65; // letter 'a'
	    int rightLimit = 90; // letter 'z'
	    int targetStringLength = 7;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    String  randomNumber = Integer.toString((int)(new Random().nextInt(99)+1));

	   // System.out.println(randomNumber+"-"+generatedString);

	   return randomNumber+"-"+generatedString;
	}


}
