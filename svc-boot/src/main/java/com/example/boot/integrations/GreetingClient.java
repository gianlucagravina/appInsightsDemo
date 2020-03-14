package com.example.boot.integrations;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.boot.models.Greeting;

@Configuration
@FeignClient(name="greeting", url = "http://localhost:10020")
public interface GreetingClient{
    
    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    Greeting getGreeting();
}