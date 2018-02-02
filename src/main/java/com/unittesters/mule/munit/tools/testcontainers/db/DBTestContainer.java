package com.unittesters.mule.munit.tools.testcontainers.db;

/**
 * 
 * <p>This connector helps to manage the <a href="https://testcontainers.org">TestContainers</a> database instance used for testing</a>.</p>
 * 
 * <p>To read more on how to build TestContainers JDBC Url, refer to the documentation <a href="https://www.testcontainers.org/usage/database_containers.html#jdbc-url">here</a>.</p>
 * @author Manik Magar
 * {@link https://manik.magar.me}
 *
 */
public class DBTestContainer {

	MuleTestContainerHolder containerHolder;
	
	/**
	 * 
	 */
	private String url;
	
	private String username;
	
	private String password;
	
	public DBTestContainer(String url, String username, String password) {
		this.setUrl(url);
		this.setUsername(username);
		this.setPassword(password);
		containerHolder = new MuleTestContainerHolder();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
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
	
	public void startContainer(){
		containerHolder.startContainer(getUrl(), getUsername(), getPassword());
	}
	
	public void stopContainer(){
		containerHolder.stopContainer();
	}
	
	
}
