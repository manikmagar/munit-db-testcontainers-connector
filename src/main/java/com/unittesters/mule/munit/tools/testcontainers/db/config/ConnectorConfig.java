package com.unittesters.mule.munit.tools.testcontainers.db.config;


import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.display.FriendlyName;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.display.Placement;
import org.mule.api.annotations.display.Summary;
import org.mule.api.annotations.param.Optional;

/**
 * Connector Configuration
 * @author Manik Magar
 *
 */

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {

	@Configurable
	@Placement(group="Connectivity")
	@FriendlyName("JDBC Url")
	@Summary("TestContainers specific JDBC Connection string.")
	private String url;
	
	@Configurable
	@Placement(group="Connectivity")
	private String username;
	
	@Configurable
	@Password
	@Placement(group="Connectivity")
	private String password;
	
	@Configurable
	@Optional
	@Placement(group="Advanced")
	@FriendlyName("Init Script Path")
	private String dbInitScript;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		//Until TC 1.6.0, If init script contains procedures or similar objects, script splitting fails. Use Attribute invocation for TC_INITSCRIPT
		if(url.contains("TC_INITSCRIPT")) {
			throw new RuntimeException("TC_INITSCRIPT parameter is not allowed in JDBC Connection String. Please set it as Init Script Path on configuration.");
		}
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbInitScript() {
		return dbInitScript;
	}

	public void setDbInitScript(String tcInitScript) {
		this.dbInitScript = tcInitScript;
	}
	
	
}