package com.java.databases.jdbc;

import java.lang.StackWalker.Option;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CRUDHandlerClass {

	protected static Boolean addUser(List formvaluesList) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DBConnectionHandler.DBconnectivityHandler();
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM registration WHERE Username ='"+formvaluesList.get(0)+"'");
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
			String Username = resultSet.getString("UserName");
			
			if(Username.equalsIgnoreCase(formvaluesList.get(0).toString())) {
				return false;
			}
			}
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO registration VALUES (default, ?,?,?,?,?)");

			ps.setString(1, formvaluesList.get(0).toString());
			ps.setString(2, formvaluesList.get(1).toString());
			ps.setString(3, formvaluesList.get(2).toString());
			ps.setString(4, formvaluesList.get(3).toString());
			ps.setString(5, formvaluesList.get(4).toString());

			ps.executeUpdate();
			System.out.println("The record has been entered into the database!");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	protected static Boolean updateUser(String updateParameter, String updateParameterNewValue, int userId,String userName ) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DBConnectionHandler.DBconnectivityHandler();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM registration WHERE ID = '"+userId+"' and UserName = '"+userName+"'");
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next() == false) {
				return false;
			}
			PreparedStatement prepareStatement = connection.prepareStatement("UPDATE `javadb`.`registration` SET `"+ updateParameter+"` = '"+updateParameterNewValue+"' WHERE (`ID` = '"+userId+"') and (`UserName` = '"+userName+"')");
			prepareStatement.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
	

	protected static Boolean deleteUser(int userId, String userName) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection  = DBConnectionHandler.DBconnectivityHandler();
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM registration WHERE ID = '"+userId+"' and UserName = '"+userName+"'");
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next() == false) {
				return false;
			}
			PreparedStatement ps = connection.prepareStatement("DELETE FROM registration WHERE ID = '"+userId+"' and UserName = '"+userName+"'");
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
	
	protected static Boolean loginuser(String userName, String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DBConnectionHandler.DBconnectivityHandler();
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM registration WHERE UserName = '"+userName+"' and password = '"+password+"'");
			ResultSet executeQuery = prepareStatement.executeQuery();
			if(executeQuery.next() == false) {
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
		
	}

	protected static Optional<Map<String, String>> retreiveUser(int userID) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Map <String, String> resultSetMap = new HashMap<>();
			Connection connection = DBConnectionHandler.DBconnectivityHandler();
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM registration WHERE ID ="+userID);
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				resultSetMap.put("Username:", resultSet.getString("UserName"));
				resultSetMap.put("Firstname:",resultSet.getString("Firstname"));
				resultSetMap.put("Lastname:",resultSet.getString("LastName"));
				resultSetMap.put("Email:",resultSet.getString("Email"));
			}
			resultSet.close();
			connection.close();
		return Optional.of(resultSetMap);
		} catch (Exception e) {
		
			
		}
		return Optional.empty();
		
	}
	
}
