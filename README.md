# MUnit DB TestContainers Anypoint Connector

This connector allows using [TestContainers](https://www.testcontainers.org/) to create Database instances for MUnit testing of Mule applications and API.

# Mule supported versions
Mule 3.5.3 and onward.

# Databases Supported

This connector uses [TestContainers](https://www.testcontainers.org/) to create database instance. Thus, it supports creating all those databases that are supported by TestContainers. See [this](https://www.testcontainers.org/usage/database_containers.html).


# Installation 
For beta connectors you can download the source code and build it with devkit to find it available on your local repository. Then you can add it to Studio.

For released connectors you can download them from the update site in Anypoint Studio. 
Open Anypoint Studio, go to Help → Install New Software and select Anypoint Connectors Update Site where you’ll find all avaliable connectors.



### Maven Dependency

```xml
<dependency>
  <groupId>com.unittesters</groupId>
  <artifactId>munit-db-testcontainers-connector</artifactId>
  <version>${tc.connector.version}</version>
  <scope>test</scope>
</dependency>
```

Get latest version from [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22munit-db-testcontainers-connector%22).

### TestContainers Database Usage Dependency 

To use the required database in your application, include the appropriate TestContainers JDBC dependency from the [latest version available on Maven Central](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22org.testcontainers%22). For example, to use MySQL Database, you would add -

```XML
<dependency>
  <groupId>org.testcontainers</groupId>
  <artifactId>mysql</artifactId>
  <version>{connector-supported-version}</version>
  <scope>test</scope>
</dependency>	
```



### Demo Usage

For information about usage our documentation at https://github.com/manikmagar/munit-db-testcontainers-demo.
YouTube presentation on VirtualMuleys channel - https://www.youtube.com/watch?v=EJ3r5uEPhKU&t=8s


# Reporting Issues

We use GitHub:Issues for tracking issues with this connector. You can report new issues at this link http://github.com/manikmagar/munit-db-testcontainers-connector/issues.
