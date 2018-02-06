package com.unittesters.mule.munit.tools.testcontainers.db.automation.functional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.unittesters.mule.munit.tools.testcontainers.db.DBTestContainerConnector;

public abstract class AbstractDBTestContainerConnectorTest extends AbstractTestCase<DBTestContainerConnector>  {

	public AbstractDBTestContainerConnectorTest() {
		super(DBTestContainerConnector.class);
	}
	
	
	public Connection getConnection() throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:tc:mysql://localhost:3306/test", "test", "test");
		return connection;
	}
	
}
