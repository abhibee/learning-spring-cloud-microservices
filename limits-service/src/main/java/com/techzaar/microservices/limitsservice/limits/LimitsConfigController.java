package com.techzaar.microservices.limitsservice.limits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigController {

  @Autowired
  private LimitConfigRepo config;

  @GetMapping(path = "/limits")
  public LimitConfig retrieveLimitsFromConfig() {
    return new LimitConfig(config.getMaximum(), config.getMinimum());
  }

  @GetMapping(path = "/fault-tolerant-example")
  @HystrixCommand(fallbackMethod = "fallbackRetrieveConfig")
  public LimitConfig retrieveConfig() {
    throw new RuntimeException();
  }

  public LimitConfig fallbackRetrieveConfig() {
    return new LimitConfig(999, 99);

  }


}
