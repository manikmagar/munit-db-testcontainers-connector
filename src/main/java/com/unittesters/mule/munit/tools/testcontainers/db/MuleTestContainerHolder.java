package com.unittesters.mule.munit.tools.testcontainers.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This utility start/stops the container and holds the connection until stopped. 
 * In general, the Container stops automatically when the last connection drops.
 * @author Manik Magar
 *
 */
public class MuleTestContainerHolder {

	Connection connection;
	
	/**
	 * Opens a new Connection to the Containerized database. 
	 * @param url
	 * @param username
	 * @param password
	 */
	public void startContainer(String url, String username, String password){
		try {
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Closes the connection managed by this instance. 
	 * If this is the last connection to container, then it results in stopping the container.
	 */
	public  void stopContainer(){
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connection = null;	
			}
		}
	}
	
}
