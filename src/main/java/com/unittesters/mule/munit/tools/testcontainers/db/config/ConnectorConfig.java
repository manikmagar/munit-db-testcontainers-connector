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
	@FriendlyName("TC_INITSCRIPT")
	private String tcInitScript;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		if(url.contains("TC_INITSCRIPT")) {
			throw new RuntimeException("TC_INITSCRIPT parameter is not allowed in JDBC Connection String. Please set it as attribute on configuration.");
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

	public String getTcInitScript() {
		return tcInitScript;
	}

	public void setTcInitScript(String tcInitScript) {
		this.tcInitScript = tcInitScript;
	}
	
	
}