package com.java.databases.JPA;

import java.time.LocalDate;

public class TicketRetreiverBean {
	
	private String airportName;
	private String flightId;
	private String gateNumber;
	private String ticketId;
	private String ticketOwnerName;
	private String ticketType;
	private String latestDepartureDate;
	private String latestReturnDate;
	
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getGateNumber() {
		return gateNumber;
	}
	public void setGateNumber(String gateNumber) {
		this.gateNumber = gateNumber;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketOwnerName() {
		return ticketOwnerName;
	}
	public void setTicketOwnerName(String ticketOwnerName) {
		this.ticketOwnerName = ticketOwnerName;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getLatestDepartureDate() {
		return latestDepartureDate.toString();
	}
	public void setLatestDepartureDate(LocalDate latestDepartureDate) {
		this.latestDepartureDate = latestDepartureDate.toString();
	}
	public String getLatestReturnDate() {
		return latestReturnDate;
	}
	public void setLatestReturnDate(LocalDate latestReturnDate) {
		this.latestReturnDate = latestReturnDate.toString();
	}
	public void setLatestReturnDate(String latestReturnDate) {
		this.latestReturnDate = latestReturnDate.toString();
	}
	@Override
	public String toString() {
		return "TicketRetreiverBean [airportName=" + airportName + ", flightId=" + flightId + ", gateNumber="
				+ gateNumber + ", ticketId=" + ticketId + ", ticketOwnerName=" + ticketOwnerName + ", ticketType="
				+ ticketType + ", latestDepartureDate=" + latestDepartureDate + ", latestReturnDate=" + latestReturnDate
				+ "]";
	}
	
	

}
