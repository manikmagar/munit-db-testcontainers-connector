package com.unittesters.mule.munit.tools.testcontainers.db.automation.functional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.unittesters.mule.munit.tools.testcontainers.db.DBTestContainerConnector;

public class StopContainerTestCases extends AbstractDBTestContainerConnectorTest {

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
	public void verifyContainerIsStopped() {
		DBTestContainerConnector c = getConnector();
		try {
			
			c.startDbContainer(false);
			c.stopDbContainer();

		} catch (Exception e) {
			Assert.fail("Unable to start and stop container.");
		}
		
	}

}