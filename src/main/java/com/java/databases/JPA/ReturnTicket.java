package com.java.databases.JPA;

import java.time.LocalDate;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ReturnTicket")
public class ReturnTicket extends Ticket implements TicketType{
	
	private LocalDate latestDepartureDate;
	private LocalDate latestReturnDate;
	private String sourceDestination;
	private String returnDestination;
	@Override
	public LocalDate getLatestDepartureDate() {
		return latestDepartureDate;
	}
	@Override
	public void setLatestDepartureDate(LocalDate latestDepartureDate) {
		this.latestDepartureDate = latestDepartureDate;
	}
	@Override
	public LocalDate getLatestReturnDate() {
		return latestReturnDate;
	}
	@Override
	public void setLatestReturnDate(LocalDate latestReturnDate) {
		this.latestReturnDate = latestReturnDate;
	}
	@Override
	public String getSourceDestination() {
		return sourceDestination;
	}
	@Override
	public void setSourceDestination(String sourceDestination) {
		this.sourceDestination = sourceDestination;
	}
	@Override
	public String getReturnDestination() {
		return returnDestination;
	}
	@Override
	public void setReturnDestination(String returnDestination) {
		this.returnDestination = returnDestination;
	}



	
	

}
