package com.java.databases.JPA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Passenger {
	
	@Column(name = "Passenger_Name")
	private String passengerName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Passenger_ID")
	private int  passengerID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Airport_ID")
	private Airport airport;
	
	@OneToMany( mappedBy = "passenger")
	private List<Ticket> tickets = new ArrayList<>();;
	
		public Passenger() {
		super();
	}


	public Passenger(String passengerName, int passengerID, Airport airport) {
		super();
		this.passengerName = passengerName;
		this.passengerID = passengerID;
		this.airport = airport;
	}


	public String getPassengerName() {
		return passengerName;
	}


	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}


	public int getPassengerID() {
		return passengerID;
	}


	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}


	public Airport getAirport() {
		return airport;
	}


	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	
	public List<Ticket> getTicket(){
		return Collections.unmodifiableList(tickets);
	}
	
	public void addTickets(Ticket ticket) {
		tickets.add(ticket);
	}
	
	
	
	
	

}
