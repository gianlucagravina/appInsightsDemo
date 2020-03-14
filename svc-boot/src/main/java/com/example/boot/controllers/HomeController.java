package com.example.boot.controllers;

// import java.time.Instant;

import com.example.boot.integrations.GreetingClient;
import com.example.boot.models.Greeting;
import com.microsoft.applicationinsights.TelemetryClient;
// import com.microsoft.applicationinsights.core.dependencies.xstream.converters.extended.DurationConverter;
// import com.microsoft.applicationinsights.telemetry.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

  @Autowired
  private TelemetryClient telemetryClient;

  @Autowired(required = false)
  private GreetingClient greetingClient;

  Logger logger = LogManager.getRootLogger();

  // @Autowired(required = false)
  // public void setGreetingClient(GreetingClient client) {
  //   this.greetingClient = client;
  // }

  @GetMapping("/boot")
  public String boot() {
      logger.info("invking boot");

      telemetryClient.trackEvent("Boot Request");
      
      logger.info("the event should have been sent");
      
      return greetingClient.getGreeting().getName();
  }
  
  @GetMapping("/manual")
  public String manual() {
    final String uri = "http://localhost:10020/greeting";
    RestTemplate restTemplate = new RestTemplate();
    Greeting retValue = restTemplate.getForObject(uri, Greeting.class);
    return retValue.getName();
  }
}