# pingid-devices-management-sample

## Overview

PingID's devices management application is a java web application example that demonstrates simple implementation operations such as add, remove and authenticate, on a device type.
This example can help a developer understand the PingID registration and authentication flow, using PPM Request/Response.

**Note**: This version only supports FIDO pairing and authentication with a hybrid UI, using FIDO2 security key and FIDO2 biometrics device types.

## System requirements and dependencies

### Prerequisites

 - A PingOne organization admin account, with the PingID service enabled.
 - An existing user.
 - The latest version of Maven (https://maven.apache.org/).


### Libraries and dependencies

 - jersey-client (https://mvnrepository.com/artifact/org.glassfish.jersey.core/jersey-client)
 - jose4j (https://mvnrepository.com/artifact/org.bitbucket.b_c/jose4j)
 - gson (https://mvnrepository.com/artifact/com.google.code.gson/gson)

 
## Installation
 
1. Download the **pingid-devices-management-sample** package.
2. Download your organization's PingID properties file (**Admin Web-Portal** -> **Setup** -> **PingID** -> **Client Integration**). See [Download the PingID properties file
](https://docs.pingidentity.com/bundle/pingid/page/pog1564020448702.html) in the PingID Aministration Guide.
3. In the `pingid-devices-management-sample/src/main/resources/properties` folder, update the `config.properties` file with the values from your organization properties file. 
4. In the `pingid-devices-management-sample/` folder, run the package build on the command line:
```
mvn clean package
```
5. Copy `pingid-devices-management-sample/target/pingid-devices-management-sample.war` to a Java web application server (for example, Tomcat).


## Usage

1. Launch the **pingid-devices-management-sample** application (for example, http://localhost:8080/pingid-devices-management-sample).
2. Login using the username of the user account.
3. Manage the user's devices with the application's `add`, `remove` and `authenticate` operations. 


## Disclaimer

This software is open sourced by Ping Identity but not supported commercially as such. Any questions/issues should go to the Github issues tracker or discuss on the [Ping Identity developer communities] . See also the DISCLAIMER file in this directory.

[Ping Identity developer communities]: https://community.pingidentity.com/collaborate
[Ping Identity Developer Site]: https://developer.pingidentity.com/connect


