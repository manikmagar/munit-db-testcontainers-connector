# MUnit DB TestContainers Release Notes
# --------------------------------------------------------------------
# Date: 02-Feb-2018

# Version: 0.0.1
# Supported API versions: 
TestContainers JDBC 1.6.0
# Supported Mule Runtime Versions: 
${project.devkitVersion}
# New Features and Functionality
Initial Version. This version allows to start and stop the Database container using specially formatted JDBC URL. See [this](https://www.testcontainers.org/usage/database_containers.html#jdbc-url) for details on JDBC URL.
# Closed Issues in this release 
# Known Issues in this release
1. TestContainers 1.6.0 ScriptUtil fails to compile stored procedures. See [testcontainers-java#570](https://github.com/testcontainers/testcontainers-java/issues/570). 
