package com.unittesters.mule.munit.tools.testcontainers.db.automation.functional;

import static org.junit.Assert.*;
import com.unittesters.mule.munit.tools.testcontainers.db.DBTestContainerConnector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class StopContainerTestCases extends AbstractTestCase<DBTestContainerConnector> {

	public StopContainerTestCases() {
		super(DBTestContainerConnector.class);
	}

	@Before
	public void setup() {
		// TODO
	}

	@After
	public void tearDown() {
		// TODO
	}

	@Test
	public void verify() {
		DBTestContainerConnector c = getConnector();
		try {
			c.startDbContainer();
			c.stopDbContainer();
		} catch (Exception e) {
			Assert.fail("Unable to start and stop container.");
		}
		
	}

}