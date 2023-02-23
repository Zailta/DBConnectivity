package com.java.databases.JPA;

import java.time.LocalDate;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("OneWayTicket")
public class OneWayTicket extends Ticket {

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



}
