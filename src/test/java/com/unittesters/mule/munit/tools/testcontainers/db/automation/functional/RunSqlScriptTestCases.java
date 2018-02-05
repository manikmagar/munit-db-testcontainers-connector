package com.unittesters.mule.munit.tools.testcontainers.db.automation.functional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.unittesters.mule.munit.tools.testcontainers.db.DBTestContainerConnector;

public class RunSqlScriptTestCases extends AbstractDBTestContainerConnectorTest {

	@Before
	public void setup() {
		// TODO
	}


	@After
	public void tearDown() {
		DBTestContainerConnector c = getConnector();
		c.stopDbContainer();
	}

	@Test
	public void verifySqlScriptIsRun() {
		DBTestContainerConnector c = getConnector();

		try {
			c.startDbContainer(false);
			
			c.runSqlScript("library_db.sql");

			try (Connection connection = getConnection()) {
				QueryRunner runner = new QueryRunner();

				String result = runner.query(connection, "select * from books", new ResultSetHandler<String>() {
					public String handle(ResultSet rs) throws SQLException {
						if (!rs.next()) {
							return null;
						}

						String result = rs.getString("title");

						return result;
					}
				});

				Assert.assertEquals("Datbase table did not return expected result", "My First Book", result);
			}

		} catch (Exception e) {
			Assert.fail("Unable to start container: " + e.getMessage());
		}

	}
	
}