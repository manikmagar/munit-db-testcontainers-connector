package com.unittesters.mule.munit.tools.testcontainers.db;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

import javax.script.ScriptException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unittesters.mule.munit.tools.testcontainers.db.utils.ScriptUtils;

/**
 * This utility start/stops the container and holds the connection until stopped. 
 * In general, the Container stops automatically when the last connection drops.
 * @author Manik Magar
 *
 */
public class MuleTestContainerHolder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScriptUtils.class);

	Connection connection;
	
	/**
	 * Opens a new Connection to the Containerized database. 
	 * @param url
	 * @param username
	 * @param password
	 */
	public void startContainer(String url, String username, String password){
		startContainer(url, username, password, null);
	}
	
	public void startContainer(String url, String username, String password, String tcInitScriptPath){
		try {
			connection = DriverManager.getConnection(url,username,password);
			runInitScriptIfRequired(tcInitScriptPath);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Run the init script if container is already started.
	 * 
	 * @param tcInitScriptPath
	 */
	public void rerunInitScript(String tcInitScriptPath){
		Objects.requireNonNull(connection, "Database connection is not initialized. Container must be started first.");
		try {
			runInitScriptIfRequired(tcInitScriptPath);
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
	
	private void runInitScriptIfRequired(String initScriptPath) throws SQLException{
		
		if (initScriptPath == null) return;
		
		try {
			
            URL resource = Thread.currentThread().getContextClassLoader().getResource(initScriptPath);

            if (resource == null) {
            	LOGGER.warn(String.format("Could not load classpath init script: {}", initScriptPath));
                throw new SQLException("Could not load classpath init script: " + initScriptPath + ". Resource not found.");
            }

            String sql = IOUtils.toString(resource, StandardCharsets.UTF_8);
            ScriptUtils.executeSqlScript(connection, initScriptPath, sql);
        } catch (IOException e) {
        	LOGGER.warn(String.format("Could not load classpath init script: {}", initScriptPath));
            throw new SQLException("Could not load classpath init script: " + initScriptPath, e);
        } catch (ScriptException e) {
        	LOGGER.error(String.format("Error while executing init script: {}", initScriptPath, e));
            throw new SQLException("Error while executing init script: " + initScriptPath, e);
        }
	}
	
}
