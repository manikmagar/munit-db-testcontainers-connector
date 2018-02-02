package com.unittesters.mule.munit.tools.testcontainers.db;

import org.mule.api.annotations.Category;
import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import com.unittesters.mule.munit.tools.testcontainers.db.config.ConnectorConfig;

/**
 * <p>This connector helps to manage the <a href="https://testcontainers.org">TestContainers</a> database instance used for testing</a>.</p>
 * 
 * <p>To read more on how to build TestContainers JDBC Url, refer to the documentation <a href="https://www.testcontainers.org/usage/database_containers.html#jdbc-url">here</a>.</p>
 * @author Manik Magar
 * {@link https://manik.magar.me}
 * 
 *
 */
@Connector(name="db-testcontainers", friendlyName="DB TestContainers")
@Category(name = "org.mule.tooling.category.munit.utils", description = "Munit tools")
public class DBTestContainerConnector {

	@Config
    ConnectorConfig config;
    
	/**
	 * Manages the container connections and lifecycle.
	 */
    MuleTestContainerHolder containerHolder = new MuleTestContainerHolder();

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }
    
    @Processor(friendlyName="Start Container",name="start-db-container")
    public void startDbContainer(){
    	containerHolder.startContainer(config.getUrl(), config.getUsername(), config.getPassword());
    }
    
    @Processor(friendlyName="Stop Container", name="stop-db-container")
    public void stopDbContainer(){
    	containerHolder.stopContainer();
    }
}