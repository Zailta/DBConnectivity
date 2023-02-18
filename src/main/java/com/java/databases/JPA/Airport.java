package com.java.databases.JPA;

import java.util.Collections;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Airport {
	@Column(name = "Airport_Name")
	private String airportName;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Airport _ID")
	private String airportID;

	@OneToMany(mappedBy = "airport")
	private List<Passenger> passengers;

	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Airport(String airportName, String airportID) {
		super();
		this.airportName = airportName;
		this.airportID = airportID;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportID() {
		return airportID;
	}

	public void setAirportID(String airportID) {
		this.airportID = airportID;
	}

	public List<Passenger> getPassenger() {
		return Collections.unmodifiableList(passengers);
	}

	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
	}

}
