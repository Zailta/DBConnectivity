package com.java.databases.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.stream.Stream;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.util.stream.*;

import com.mysql.cj.Session;
import com.mysql.cj.util.Util;

/**
 * Servlet implementation class RequesthandlerClass
 */
@MultipartConfig
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
		
/*
 *Switch case starts Here:
 *Adding New User */		
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
			Part imagePart = request.getPart("image");
			Boolean addUser = CRUDHandlerClass.addUser(formparameters, imagePart);
			if (addUser) {
				response.getWriter().println("The data has been entered successfully!");
			} else {
				response.getWriter().println("The data Insertion Failed, UserName already exists in DB!");
			}
		break;
		}
		
/*Searching User */			
		case "search": {
			int parameter = Integer.parseInt(request.getParameter("UserID"));
			Optional<Map<String, String>> retreiveUser = CRUDHandlerClass.retreiveUser(parameter);
			retreiveUser.stream().forEach(x -> {
				x.entrySet().stream().forEach(e -> {
					try {
						response.getWriter().println(e.getKey() + "= " + e.getValue());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});

			});

			break;

		}
		
		
		case "login": {
			String username = request.getParameter("UserName");
			String password = request.getParameter("password");
			request.getSession().setAttribute("userName", username);
			Boolean loginuserFlag = CRUDHandlerClass.loginuser(username, password);
			if (loginuserFlag) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				response.getWriter().println("Login failure!");
			}
			break;

		}
		
		
		case "delete": {
			String UserName = (String) request.getSession().getAttribute("userName");

			if (UserName.equalsIgnoreCase("admin")) {

				Boolean deleteUser = CRUDHandlerClass.deleteUser(Integer.parseInt(request.getParameter("userId")),
						request.getParameter("userName"));
				if (deleteUser) {
					response.getWriter().println("User deleted Successfully!");
				} else {
					response.getWriter().println("User does not exist in DB");
				}
			} else {
				response.getWriter().println("You do not have the required priveleges to perform the operation");
			}

			break;
		}
		
		
		case "update": {
			String UserName = (String) request.getSession().getAttribute("userName");

			if (UserName.equalsIgnoreCase("admin")) {

				Boolean updateUser = CRUDHandlerClass.updateUser(request.getParameter("parameter"),
						request.getParameter("updatedValue"), Integer.parseInt(request.getParameter("userId")),
						request.getParameter("userName"));
				if (updateUser) {
					response.getWriter().println("User Updated Successfully!");
				} else {
					response.getWriter().println("User does not exist in DB");
				}
			} else {
				response.getWriter().println("You do not have the required priveleges to perform the operation");
			}

			break;

		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + crudCall);
		}
	}

}
