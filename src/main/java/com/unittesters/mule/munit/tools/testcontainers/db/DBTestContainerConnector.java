package com.unittesters.mule.munit.tools.testcontainers.db;

import java.sql.SQLException;

import org.mule.api.annotations.Category;
import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.display.FriendlyName;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

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
    
    /**
     * Starts the Containerized Database instance.
     * @param runInitScript when true, Runs the init script if set at config level
     */
    @Processor(friendlyName="Start Container",name="start-db-container")
    public void startDbContainer(@Optional @FriendlyName("Run Init if configured") @Default("false") boolean runInitScript){
    	containerHolder.startContainer(config.getUrl(), config.getUsername(), config.getPassword(), runInitScript?config.getDbInitScript():null);
    }
    
    /**
     * Closes the connection managed by this connector. If there is no other connection to the target TestContainer, then it should get closed soon.
     */
    @Processor(friendlyName="Stop Container", name="stop-db-container")
    public void stopDbContainer(){
    	containerHolder.stopContainer();
    }
    
    /**
     * {@link ConnectorConfig#dbInitScript} must be set on configuration for this operation to run succcessfully.
     * @throws SQLException
     */
    @Processor(friendlyName="Run Init Script", name="run-init-script")
    public void runInitScript() throws SQLException {
    	containerHolder.runSqlScript(config.getDbInitScript());
    }
    
    /**
     * Runs the given SQL Script file to the database instance. This can be used to pre-set database for test.
     * @param sqlScriptPath File on classpath.
     * @throws SQLException
     */
    @Processor(friendlyName="Run Sql Script", name="run-sql-script")
    public void runSqlScript(@FriendlyName("SQL Script Path") String sqlScriptPath) throws SQLException {
    	containerHolder.runSqlScript(sqlScriptPath);
    }
}