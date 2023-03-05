package com.java.databases.JPA;

import java.time.LocalDate;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import jakarta.persistence.EntityManager;

import jakarta.persistence.Persistence;

public class EntityManagerHandler {

	public static JsonObject findTicket(String ticketcode) {
		/*
		 * GsonBuilder gsonBuilder = new GsonBuilder();
		 * gsonBuilder.registerTypeAdapter(LocalDate.class, new
		 * LocalDateDeserializer());
		 */

		EntityManager entityManager = Persistence.createEntityManagerFactory("unit1").createEntityManager();
		entityManager.getTransaction().begin();
		TicketHashCodeGenerator codeGenerator = new TicketHashCodeGenerator(ticketcode);
		TicketType ticket = (entityManager.find(OneWayTicket.class, codeGenerator));
		entityManager.close();
		TicketRetreiverBean retreiverBean = new TicketRetreiverBean();
		return ticketJSONRetriever((OneWayTicket) ticket, retreiverBean);
	}

	public static void addUser() {
		EntityManager entityManager = Persistence.createEntityManagerFactory("unit1").createEntityManager();
		entityManager.getTransaction().begin();

		Airport srinagar = new Airport();
		srinagar.setAirportName("Srinagar International Airport");
		Airport bangalore = new Airport();
		bangalore.setAirportName("karnataka International Airport");

		Passenger mannan = new Passenger();
		mannan.setPassengerName("Mohammad Manaan Bhat");
		mannan.setAirport(srinagar);
		srinagar.addPassenger(mannan);

		Passenger azam = new Passenger();
		azam.setPassengerName("Mohammad Azam Bhat");
		azam.setAirport(bangalore);
		bangalore.addPassenger(azam);

		OneWayTicket srinagarTicket = new OneWayTicket();
		srinagarTicket.setPassenger(mannan);
		srinagarTicket.setSourceDestination("DEL");
		srinagarTicket.setLatestDepartureDate(LocalDate.of(2023, 03, 8));
		mannan.addTickets(srinagarTicket);

		ReturnTicket bangaloreTicket = new ReturnTicket();
		bangaloreTicket.setPassenger(azam);
		bangaloreTicket.setLatestDepartureDate(LocalDate.now()/* of(2023, Month.DECEMBER, 20) */);
		bangaloreTicket.setSourceDestination("CHE");
		bangaloreTicket.setReturnDestination("ANR");
		bangaloreTicket.setLatestReturnDate(LocalDate.now()/* of(2023, Month.JUNE, 11) */);
		azam.addTickets(bangaloreTicket);

		entityManager.persist(srinagar);
		entityManager.persist(bangalore);
		entityManager.persist(mannan);
		entityManager.persist(azam);
		entityManager.persist(srinagarTicket);
		entityManager.persist(bangaloreTicket);

		entityManager.getTransaction().commit();
		entityManager.close();

	}

	private static JsonObject ticketJSONRetriever(OneWayTicket ticket, TicketRetreiverBean retreiverBean) {
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		retreiverBean.setAirportName(ticket.getPassenger().getAirport().getAirportName());
		FlightGenerator flightGenerator = ticket.getPassenger().getAirport().getFlightGenerator();
		retreiverBean.setFlightId(flightGenerator.getFlightId());
		GateGenerator gateGenerator = ticket.getPassenger().getAirport().getGateGenerator();
		retreiverBean.setGateNumber(gateGenerator.getGateId());
		String ticketCode = ticket.getTicketHashCodeGenerator().getTicketCode();
		retreiverBean.setTicketId(ticketCode);
		retreiverBean.setTicketOwnerName(ticket.getPassenger().getPassengerName());
		retreiverBean.setLatestDepartureDate(ticket.getLatestDepartureDate());
		retreiverBean.setTicketType("One-Way Ticket");
		retreiverBean.setLatestReturnDate("N/A");
		JsonElement jsonTree = gson.toJsonTree(retreiverBean);
		jsonObject.add("retreiverBean", jsonTree);
		return jsonObject;
	}


}
