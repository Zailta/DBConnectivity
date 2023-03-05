package com.java.databases.JPA;

import java.time.LocalDate;

public interface TicketType {
	
	LocalDate getLatestDepartureDate();
	String getSourceDestination();
	LocalDate getLatestReturnDate();
	String getReturnDestination();
	void setReturnDestination(String returnDestination);
	void setSourceDestination(String sourceDestination);
	void setLatestReturnDate(LocalDate latestReturnDate);
	void setLatestDepartureDate(LocalDate latestDepartureDate);

}
