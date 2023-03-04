package com.java.databases.JPA;


import java.time.LocalDate;
import java.time.Month;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import jakarta.persistence.EntityManager;

import jakarta.persistence.Persistence;



public class EntityManagerHandler {

	public static String findTicket(String ticketcode) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
		Gson gson = gsonBuilder.setPrettyPrinting().create();
		JsonObject jsonObject = new JsonObject();
		
		EntityManager entityManager = Persistence.createEntityManagerFactory("unit1").createEntityManager();
		entityManager.getTransaction().begin();
		TicketHashCodeGenerator codeGenerator = new TicketHashCodeGenerator(ticketcode);
		OneWayTicket ticket = entityManager.find(OneWayTicket.class, codeGenerator);
		entityManager.close();
		System.out.println(ticket.getLatestDepartureDate());
		JsonElement jsonTree = gson.toJsonTree(ticket);
		jsonObject.add("ticket", jsonTree);
		System.out.println(jsonObject);
		return ticket.getTicketHashCodeGenerator().getTicketCode();
	}
	
	public static void addUser() {
		EntityManager entityManager = Persistence.createEntityManagerFactory("unit1").createEntityManager();
		entityManager.getTransaction().begin();

		Airport srinagar = new Airport();
		  srinagar.setAirportName("Srinagar International Airport"); Airport bangalore
		  = new Airport(); bangalore.setAirportName("karnataka International Airport");
		  
		  Passenger mannan = new Passenger();
		  mannan.setPassengerName("Mohammad Manaan Bhat"); mannan.setAirport(srinagar);
		  srinagar.addPassenger(mannan);
		  
		  Passenger azam = new Passenger();
		  azam.setPassengerName("Mohammad Azam Bhat"); azam.setAirport(bangalore);
		  bangalore.addPassenger(azam);
		  
		  OneWayTicket srinagarTicket = new OneWayTicket();
		  srinagarTicket.setPassenger(mannan);
		  srinagarTicket.setSourceDestination("DEL");
		  srinagarTicket.setLatestDepartureDate(LocalDate.of(2023, 03, 8));
		  mannan.addTickets(srinagarTicket);
		  
		  ReturnTicket bangaloreTicket = new ReturnTicket();
		  bangaloreTicket.setPassenger(azam);
		  bangaloreTicket.setLatestDepartureDate(LocalDate.now()/*of(2023, Month.DECEMBER, 20)*/);
		  bangaloreTicket.setSourceDestination("CHE");
		  bangaloreTicket.setReturnDestination("ANR");
		  bangaloreTicket.setLatestReturnDate(LocalDate.now()/*of(2023, Month.JUNE, 11)*/);
		  azam.addTickets(bangaloreTicket);
		
		  entityManager.persist(srinagar); entityManager.persist(bangalore);
		  entityManager.persist(mannan); entityManager.persist(azam);
		  entityManager.persist(srinagarTicket);
		  entityManager.persist(bangaloreTicket);
		  
		  entityManager.getTransaction().commit(); 
		  entityManager.close();
		 
	}
	public static void main(String[] args) {
		findTicket("76-VEJQVPK");
		//addUser();
	}

}
