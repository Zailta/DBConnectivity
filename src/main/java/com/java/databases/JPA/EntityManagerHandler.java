package com.java.databases.JPA;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerHandler {

	public static String findTicket(String ticketcode) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("unit1").createEntityManager();
		entityManager.getTransaction().begin();

		TicketHashCodeGenerator codeGenerator = new TicketHashCodeGenerator(ticketcode);

		Ticket find = entityManager.find(Ticket.class, codeGenerator);
		return (find.getPassenger().getPassengerName());
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
		  bangaloreTicket.setLatestDepartureDate(LocalDate.of(2023, 05, 11));
		  bangaloreTicket.setSourceDestination("CHE");
		  bangaloreTicket.setReturnDestination("ANR");
		  bangaloreTicket.setLatestReturnDate(LocalDate.of(2023, 11, 15));
		  azam.addTickets(bangaloreTicket);
		  
		  
		  entityManager.persist(srinagar); entityManager.persist(bangalore);
		  entityManager.persist(mannan); entityManager.persist(azam);
		  entityManager.persist(srinagarTicket);
		  entityManager.persist(bangaloreTicket);
		  
		  entityManager.getTransaction().commit(); entityManager.close();
		 
	}

}
