#pingid-devices-management-sample

### Overview

PingID's devices management is a sample java web application that demonstrates simple implementation operations on device type, such as add, remove and authenticate.
This sample application can help a developer to understand the PingID registration and authentication flow, using PPM Request/Response.

note: This version supports only (Hybrid FIDO2 UI with pingone domain) FIDO2 devices types such as Security key and FIDO2 Biometrics.

### System Requirements / Dependencies

Requires:
 - PingOne account with PingID service enabled (visit [Ping Identity Developer Site] to get a developer account)
 - An existing user.

Libraries & Dependencies:
 - jersey-client (https://mvnrepository.com/artifact/org.glassfish.jersey.core/jersey-client)
 - jose4j (https://mvnrepository.com/artifact/org.bitbucket.b_c/jose4j)
 - gson (https://mvnrepository.com/artifact/com.google.code.gson/gson)

 
### Installation
 
1. Install the latest Maven (https://maven.apache.org/).
2. Download organization properties file. (can be download from the Admin Web-Portal -> Setup -> PingID -> Client Integration).
3. Go to resources/properties folder and update the properties values with the values of your organization properties file. 
4. Open a command line and from {your_location}/pingid-devices-mgmt-sample/ execute:
```
mvn clean package
```
5. Copy target\pingid-devices-mgmt-sample.war to a Java web application server (i.e. Tomcat).


### Usage

1. Launch the application (i.e. https://localhost:8080/pingid-devices-mgmt-sample).
2. Login with user name.
3. Add, remove and authenticate operations are available to manage the user's devices. 


### Disclaimer

This software is open sourced by Ping Identity but not supported commercially as such. Any questions/issues should go to the Github issues tracker or discuss on the [Ping Identity developer communities] . See also the DISCLAIMER file in this directory.

[Ping Identity developer communities]: https://community.pingidentity.com/collaborate
[Ping Identity Developer Site]: https://developer.pingidentity.com/connect





