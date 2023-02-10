package com.java.databases.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CRUDHandlerClass {

	protected static void addUser(List formvaluesList) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DBConnectionHandler.DBconnectivityHandler();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO registration VALUES (default, ?,?,?,?,?)");

			ps.setString(1, formvaluesList.get(0).toString());
			ps.setString(2, formvaluesList.get(1).toString());
			ps.setString(3, formvaluesList.get(2).toString());
			ps.setString(4, formvaluesList.get(3).toString());
			ps.setString(5, formvaluesList.get(4).toString());

			ps.executeUpdate();
			System.out.println("The record has been entered into teh database!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void updateUser(String updateParameter, String updateParameterNewValue, int userId,String userName ) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DBConnectionHandler.DBconnectivityHandler();
			PreparedStatement prepareStatement = connection.prepareStatement("UPDATE `javadb`.`registration` SET `"+ updateParameter+"` = '"+updateParameterNewValue+"' WHERE (`ID` = '"+userId+"') and (`UserName` = '"+userName+"')");
			prepareStatement.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	protected static void deleteUser(int userId, String userName) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection  = DBConnectionHandler.DBconnectivityHandler();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM `javadb`.`registration` WHERE (`"+userId+"` = '5') and (`UserName` = '"+userName+"')");
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected static void retreiveUser(int userID) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DBConnectionHandler.DBconnectivityHandler();
			PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM registration WHERE ID ="+userID);
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("UserName"));
				System.out.println(resultSet.getString("Firstname"));
				System.out.println(resultSet.getString("LastName"));
				System.out.println(resultSet.getString("Email"));
				System.out.println(resultSet.getString("Email"));
			}
			resultSet.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
