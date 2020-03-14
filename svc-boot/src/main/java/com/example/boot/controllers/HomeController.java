package com.example.boot.controllers;

// import java.time.Instant;

import com.example.boot.integrations.GreetingClient;
import com.example.boot.models.Greeting;
import com.microsoft.applicationinsights.TelemetryClient;
// import com.microsoft.applicationinsights.core.dependencies.xstream.converters.extended.DurationConverter;
// import com.microsoft.applicationinsights.telemetry.Duration;

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

  // @Autowired(required = false)
  // public void setGreetingClient(GreetingClient client) {
  //   this.greetingClient = client;
  // }

  @GetMapping("/boot")
  public String boot() {
      

      telemetryClient.trackEvent("Boot Request");
      
      
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