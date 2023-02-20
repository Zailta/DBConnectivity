package com.java.databases.JPA;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
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
	private int ticketID;
	
	@Embedded
	@AttributeOverride(name = "ticketCode", column = @Column(name = "Ticket_Code"))
	private TicketHashCodeGenerator ticketHashCodeGenerator;
	
	@ManyToOne
	@JoinColumn(name = "Passenger_ID")
	private Passenger passenger;
	public Ticket() {
		super();
		TicketHashCodeGenerator ticketCode = new TicketHashCodeGenerator();
		setTicketHashCodeGenerator(ticketCode);
	}
	
	public Ticket(int ticketID,Passenger passenger) {
		super();
		this.ticketID = ticketID;
		this.passenger = passenger;
	}



	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public TicketHashCodeGenerator getTicketHashCodeGenerator() {
		return ticketHashCodeGenerator;
	}

	public void setTicketHashCodeGenerator(TicketHashCodeGenerator ticketHashCodeGenerator) {
		this.ticketHashCodeGenerator = ticketHashCodeGenerator;
	}
	
	
	
}
