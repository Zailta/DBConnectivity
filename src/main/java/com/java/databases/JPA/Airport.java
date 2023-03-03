package com.java.databases.JPA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@Column(name = "Airport_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airportID;

	@OneToMany( mappedBy = "airport")
	private List<Passenger> passengers = new ArrayList<>();
	
	@Embedded
	@AttributeOverride(name = "flightId", column = @Column(name = "Flight_ID"))
	private FlightGenerator flightGenerator;
	@Embedded
	@AttributeOverride(name = "gateId", column = @Column(name = "Gate_ID"))
	private GateGenerator gateGenerator;

	public Airport() {
		super();
		FlightGenerator flightGenerator = new FlightGenerator();
		GateGenerator gateGenerator = new GateGenerator();
		setFlightGenerator(flightGenerator);
		setGateGenerator(gateGenerator);
		// TODO Auto-generated constructor stub
	}

	public Airport(String airportName, int airportID) {
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

	public int getAirportID() {
		return airportID;
	}

	public void setAirportID(int airportID) {
		this.airportID = airportID;
	}

	public List<Passenger> getPassenger() {
		return Collections.unmodifiableList(passengers);
	}

	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
	}

	public FlightGenerator getFlightGenerator() {
		return flightGenerator;
	}

	private void setFlightGenerator(FlightGenerator flightGenerator) {
		this.flightGenerator = flightGenerator;
	}

	public GateGenerator getGateGenerator() {
		return gateGenerator;
	}

	private void setGateGenerator(GateGenerator gateGenerator) {
		this.gateGenerator = gateGenerator;
	}

}
