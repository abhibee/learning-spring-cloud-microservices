package com.techzaar.microservices.currencyconversionservice.conversion;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeFeignProxy feignproxy;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping(path = "/currency-conversion/from/{from}/to/{to}/{quantity}")
	public CurrencyValueBean getCurrencyConvertedValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> parameterMap = new HashMap<>();
		parameterMap.put("from", from);
		parameterMap.put("to", to);
		ResponseEntity<CurrencyValueBean> currencyValueResponse = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyValueBean.class, parameterMap);
		CurrencyValueBean value = currencyValueResponse.getBody();

		return new CurrencyValueBean(value.getId(), from, to, value.getConversionMultiple(), quantity,
				quantity.multiply(value.getConversionMultiple()), value.getPort());
	}

	@GetMapping(path = "/currency-conversion-feign/from/{from}/to/{to}/{quantity}")
	public CurrencyValueBean getCurrencyConvertedValueFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyValueBean value = feignproxy.getCurrencyExchangeValue(from, to);

		logger.info("{}", value);

		CurrencyValueBean returnval = new CurrencyValueBean(value.getId(), from, to, value.getConversionMultiple(),
				quantity, quantity.multiply(value.getConversionMultiple()), value.getPort());

		return returnval;
	}

}
