package com.unittesters.mule.munit.tools.testcontainers.db.automation.functional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.mule.tools.devkit.ctf.junit.AbstractTestCase;
import org.mule.util.PropertiesUtils;

import com.unittesters.mule.munit.tools.testcontainers.db.DBTestContainerConnector;

public abstract class AbstractDBTestContainerConnectorTest extends AbstractTestCase<DBTestContainerConnector>  {

	public AbstractDBTestContainerConnectorTest() {
		super(DBTestContainerConnector.class);
	}
	
	
	public Connection getConnection() throws Exception{
		Properties props = PropertiesUtils.loadProperties("automation-credentials.properties", AbstractDBTestContainerConnectorTest.class);
		Connection connection = DriverManager.getConnection(props.getProperty("config.url"), props.getProperty("config.username"),props.getProperty("config.password"));
		return connection;
	}
	
}
