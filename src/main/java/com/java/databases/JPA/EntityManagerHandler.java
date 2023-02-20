package com.java.databases.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerHandler {
	public static void main(String[] args) {
		
		
		  EntityManager entityManager =
		  Persistence.createEntityManagerFactory("unit1").createEntityManager();
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

		 Ticket srinagarTicket = new Ticket();
		 srinagarTicket.setPassenger(mannan);
		 mannan.addTickets(srinagarTicket);
		 
		 Ticket bangaloreTicket = new Ticket();
		 bangaloreTicket.setPassenger(azam);
		 azam.addTickets(bangaloreTicket);
		 

			  entityManager.persist(srinagar); entityManager.persist(bangalore);
			  entityManager.persist(mannan); entityManager.persist(azam);
			  entityManager.persist(srinagarTicket);
			  entityManager.persist(bangaloreTicket);
			  
			  
			  
			  entityManager.getTransaction().commit(); 
			  entityManager.close();
			 
			 
		 
	}

}
