package com.metacube.assignment.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.PropertySource;

/*
 * This is use for connection.
 */
@PropertySource("classpath:application.yml")
public class ConnectionUtility {

	private String driverPath = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/metaparking";
	private String userName = "root";
	private String password = "keyur";

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
