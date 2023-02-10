package com.java.databases.jdbc;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DBConnectionHandler {

	private static Path filepath = Paths
			.get("C:\\Users\\hp\\eclipse-workspace\\DBconnectivity\\src\\main\\webapp\\DBCredentials.txt");

	private static List<String> readPropertyFile() {

		List<String> credentialsArray = new ArrayList<String>();

		try (BufferedReader bufferedReader = Files.newBufferedReader(filepath);
				Stream<String> lines = bufferedReader.lines();) {
			credentialsArray = lines.map(e -> {
				return splitFnction(e);
			}).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return credentialsArray;

	}

	private static String splitFnction(String e) {
		String[] split = e.split("=");
		return split[1].trim();
	}

	protected static Connection DBconnectivityHandler() throws Exception {
		List<String> readPropertyFile = readPropertyFile();

		Connection connection = DriverManager.getConnection(readPropertyFile.get(0), readPropertyFile.get(1),
				readPropertyFile.get(2));
		return connection;

	}

}
