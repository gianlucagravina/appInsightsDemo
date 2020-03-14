# Introduction 
Demo to use Application Insights in a Spring Boot Application, leveraging FeignClients

# Greeting Service
This Services simulate the external service to be called (and tracked by the main one as an external dependency)
- cd into `svc-greeting` and launch `gradle build`
- launch `gradle bootRun` to launch the service listening on the port 10020

# Boot Service
this is the main api that depends on the greeting service.
- cd into svc-boot
- Create an AppInsights resource on auzre and get the instrumentation key. Use the instrumentation key in the `src/main/resources/` `application.yml` and `log4j.xml`
- launch `gradle build`
- launch `./runServer.sh` if you are on linux or launch `java -javaagent:ext-libs/agent.jar -jar build/libs/boot-0.0.1-SNAPSHOT.jar`