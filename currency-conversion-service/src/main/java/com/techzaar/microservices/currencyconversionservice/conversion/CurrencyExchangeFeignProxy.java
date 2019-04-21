package com.techzaar.microservices.currencyconversionservice.conversion;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeFeignProxy {

	@GetMapping(path="/currency-exchange/from/{from}/to/{to}")
	public CurrencyValueBean getCurrencyExchangeValue(@PathVariable String from,@PathVariable String to);

	
}