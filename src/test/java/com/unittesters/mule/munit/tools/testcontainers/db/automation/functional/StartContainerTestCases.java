package com.unittesters.mule.munit.tools.testcontainers.db.automation.functional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.unittesters.mule.munit.tools.testcontainers.db.DBTestContainerConnector;

public class StartContainerTestCases extends AbstractTestCase<DBTestContainerConnector> {

	public StartContainerTestCases() {
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
		} catch (Exception e) {
			Assert.fail("Unable to start container: "+ e.getMessage());
		}
		
	}

}