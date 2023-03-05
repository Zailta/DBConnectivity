package com.java.databases.JPA;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class UIHandler
 */
public class UIHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UIHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ticketcode = request.getParameter("ticketCode");
		 JsonObject TicketObject = EntityManagerHandler.findTicket(ticketcode);
		 System.out.println(TicketObject);
		 
		response.getWriter().println(TicketObject.toString());
		response.getWriter().close();
		
		
	}

}
