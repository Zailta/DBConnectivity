package com.java.databases.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ticketID;
	@Column(name = "Ticket_Code")
	private TicketHashCodeGenerator ticketHashCodeGenerator;
	
	@ManyToOne
	@JoinColumn(name = "Passenger_ID")
	private Passenger passenger;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(String ticketID, TicketHashCodeGenerator ticketHashCodeGenerator) {
		super();
		this.ticketID = ticketID;
		this.ticketHashCodeGenerator = ticketHashCodeGenerator;
	}
	public String getTicketID() {
		return ticketID;
	}
	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	public TicketHashCodeGenerator getTicketHashCodeGenerator() {
		return ticketHashCodeGenerator;
	}
	public void setTicketHashCodeGenerator(TicketHashCodeGenerator ticketHashCodeGenerator) {
		this.ticketHashCodeGenerator = ticketHashCodeGenerator;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	
	
	
}
