package com.java.databases.JPA;

import java.time.LocalDate;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ReturnTicket")
public class ReturnTicket extends Ticket{
	
	private LocalDate latestDepartureDate;
	private LocalDate latestReturnDate;
	private String sourceDestination;
	private String returnDestination;
	public LocalDate getLatestDepartureDate() {
		return latestDepartureDate;
	}
	public void setLatestDepartureDate(LocalDate latestDepartureDate) {
		this.latestDepartureDate = latestDepartureDate;
	}
	public LocalDate getLatestReturnDate() {
		return latestReturnDate;
	}
	public void setLatestReturnDate(LocalDate latestReturnDate) {
		this.latestReturnDate = latestReturnDate;
	}
	public String getSourceDestination() {
		return sourceDestination;
	}
	public void setSourceDestination(String sourceDestination) {
		this.sourceDestination = sourceDestination;
	}
	public String getReturnDestination() {
		return returnDestination;
	}
	public void setReturnDestination(String returnDestination) {
		this.returnDestination = returnDestination;
	}
	

	
	

}
