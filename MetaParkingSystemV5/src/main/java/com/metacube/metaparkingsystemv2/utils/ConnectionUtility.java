package com.metacube.metaparkingsystemv2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.PropertySource;

public class ConnectionUtility {

	private String driverPath = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/metaparkingdbv2";
	private String userName = "root";
	private String password = "admin";

	public Connection createConnection() {
		Connection connection = null;
		System.out.println(driverPath + " " + url + " " + userName + " " + password);
		try {
			Class.forName(driverPath);
			connection = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return connection;
	}

	public boolean closeConnection(Connection connection) {
		boolean isConnectionClosed = false;
		try {
			connection.close();
			isConnectionClosed = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isConnectionClosed;
	}
}
