package com.comcast.crm.generic.DataBaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author gulshan
 *
 */
public class DataBaseUtility {

	Connection conn;

	/**
	 * this method will perform the mySQL Database connection
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @throws SQLException
	 */

	/* method for create connection */
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

	/**
	 * this method perform the disconnection from database
	 * 
	 * @throws SQLException
	 */

	/* method for close the connection */
	public void closeConnection() throws SQLException {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	/**
	 * this method will perform select query action
	 * 
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	// method for select query
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result = null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * this method will perform non select query action
	 * 
	 * @param query
	 * @return
	 */
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
