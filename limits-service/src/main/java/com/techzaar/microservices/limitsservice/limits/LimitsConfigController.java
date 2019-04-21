package com.techzaar.microservices.limitsservice.limits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigController {

	@Autowired
	private LimitConfigRepo config;

	@GetMapping(path = "/limits")
	public LimitConfig retrieveLimitsFromConfig() {
		return new LimitConfig(config.getMaximum(), config.getMinimum());

	}

}
