package com.unittesters.mule.munit.tools.testcontainers.db.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.unittesters.mule.munit.tools.testcontainers.db.automation.functional.StartContainerTestCases;
import com.unittesters.mule.munit.tools.testcontainers.db.automation.functional.StopContainerTestCases;
import com.unittesters.mule.munit.tools.testcontainers.db.DBTestContainerConnector;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

@RunWith(Suite.class)
@SuiteClasses({ StartContainerTestCases.class, StopContainerTestCases.class })

public class FunctionalTestSuite {

	@BeforeClass
	public static void initialiseSuite() {
		ConnectorTestContext.initialize(DBTestContainerConnector.class);
	}

	@AfterClass
	public static void shutdownSuite() {
		ConnectorTestContext.shutDown();
	}

}