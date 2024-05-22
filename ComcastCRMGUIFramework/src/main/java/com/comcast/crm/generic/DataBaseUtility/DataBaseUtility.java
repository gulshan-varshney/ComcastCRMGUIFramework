package com.comcast.crm.generic.DataBaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	Connection conn;

	// method for create connection
	public void getDbConnection(String url, String username, String password) throws SQLException {

		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
		}
	}

	public void getDbConnection() throws SQLException {

		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		} catch (Exception e) {
		}
	}

	// method for close the connection
	public void closeConnection() throws SQLException {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	// method for select query
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result = null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
		} catch (Exception e) {}
		return result;
	}

	// method for non-select query
	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {
		}
		return result;
	}
}
