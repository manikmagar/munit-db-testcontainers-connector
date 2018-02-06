# MUnit DB TestContainers Release Notes
--------------------------------------------------------------------

## [0.0.3] - 02/05/2018

1. Added Run Init Script and Run SQL Script operations.
2. Fixed TestContainers ScriptUtil to compile SQL Objects like Stored Procedures.

### Supported API versions:

TestContainers JDBC 1.6.0

### Supported Mule Runtime Versions:

Mul3 3.5.3 and Later but until Mule 3.X only.

### New Features and Functionality

1. Run Init Script operation to initialize database for pre-set objects.
2. Run SQL Script opration to allow running any SQL script to set the data.

### Closed Issues in this release

1. TestContainers 1.6.0 ScriptUtil fails to compile stored procedures. See [testcontainers-java#570](https://github.com/testcontainers/testcontainers-java/issues/570). 

### Known Issues in this release

1. Mule 4.0 is not supported.

## 

## [0.0.2] - 02/03/2018

Minor code optimizations.

### Supported API versions:

TestContainers JDBC 1.6.0

### Supported Mule Runtime Versions:

Mul3 3.5.3 and Later but until Mule 3.X only.

### New Features and Functionality

### Closed Issues in this release

### Known Issues in this release

1. TestContainers 1.6.0 ScriptUtil fails to compile stored procedures. See [testcontainers-java#570](https://github.com/testcontainers/testcontainers-java/issues/570). 
2. Mule 4.0 is not supported.

## 

## [0.0.1] - 02/02/2018

Initial Version. This version allows to start and stop the Database container using specially formatted JDBC URL. See [this](https://www.testcontainers.org/usage/database_containers.html#jdbc-url) for details on JDBC URL.

### Supported API versions: 
TestContainers JDBC 1.6.0
### Supported Mule Runtime Versions: 
Mul3 3.5.3 and Later but until Mule 3.X only.
### New Features and Functionality

### Closed Issues in this release 



### Known Issues in this release
1. TestContainers 1.6.0 ScriptUtil fails to compile stored procedures. See [testcontainers-java#570](https://github.com/testcontainers/testcontainers-java/issues/570). 
2. Mule 4.0 is not supported.
