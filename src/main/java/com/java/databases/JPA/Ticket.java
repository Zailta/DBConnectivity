package com.java.databases.JPA;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Ticket_Type")
public class Ticket {
	
	
	@EmbeddedId
	@AttributeOverride(name = "ticketCode", column = @Column(name = "Ticket_Code"))
	private TicketHashCodeGenerator ticketHashCodeGenerator;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Passenger_ID")
	private Passenger passenger;

	public Ticket() {
		super();
		TicketHashCodeGenerator ticketCode = new TicketHashCodeGenerator();
		setTicketHashCodeGenerator(ticketCode);
	}
	public Ticket(TicketHashCodeGenerator hashCodeGenerator) {
		super();
		this.ticketHashCodeGenerator = hashCodeGenerator;
		
	}
	
	public Ticket(Passenger passenger) {
		super();
		this.passenger = passenger;
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

	private void setTicketHashCodeGenerator(TicketHashCodeGenerator ticketHashCodeGenerator) {
		this.ticketHashCodeGenerator = ticketHashCodeGenerator;
	}
	
	
}
