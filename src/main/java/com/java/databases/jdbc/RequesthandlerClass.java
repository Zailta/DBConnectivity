package com.java.databases.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.stream.Stream;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.*;

import com.mysql.cj.util.Util;

/**
 * Servlet implementation class RequesthandlerClass
 */
public class RequesthandlerClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequesthandlerClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String crudCall = request.getParameter("crudCall");
		
		switch (crudCall) {
		case "newuser": {
			Map requestParameterMap = request.getParameterMap();
			Iterator iterator = requestParameterMap.keySet().iterator();
			List<String> formparameters = new ArrayList<>();

			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				String value = request.getParameter(key);
				formparameters.add(value);
			}
			System.out.println(formparameters);
			
			CRUDHandlerClass.addUser(formparameters);
			break;
			}
		case "search": {
			int parameter = Integer.parseInt(request.getParameter("UserID"));
			Optional<Map<String, String>> retreiveUser = CRUDHandlerClass.retreiveUser(parameter);
			retreiveUser.stream().forEach(x-> {
					x.entrySet().stream().forEach(e->{
					try {
						response.getWriter().println(e.getKey()+"= "+e.getValue());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					});

			});
			
			
			
			break;
			
		}
		case "login": {}
		case "delete": {}
		case "update": {}
		default:
			throw new IllegalArgumentException("Unexpected value: " + crudCall);
		}
	}

}
