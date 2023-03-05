package com.java.databases.JPA;

import java.time.LocalDate;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("OneWayTicket")
public class OneWayTicket extends Ticket implements TicketType {

	private LocalDate latestDepartureDate;
	private String sourceDestination;
	
	public LocalDate getLatestDepartureDate() {
		return latestDepartureDate;
	}
	public void setLatestDepartureDate(LocalDate latestDepartureDate) {
		this.latestDepartureDate = latestDepartureDate;
	}
	public String getSourceDestination() {
		return sourceDestination;
	}
	public void setSourceDestination(String sourceDestination) {
		this.sourceDestination = sourceDestination;
	}
	@Override
	public LocalDate getLatestReturnDate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getReturnDestination() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setReturnDestination(String returnDestination) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setLatestReturnDate(LocalDate latestReturnDate) {
		// TODO Auto-generated method stub
		
	}



}
