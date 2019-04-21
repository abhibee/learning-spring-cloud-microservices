package com.techzaar.microservices.currencyexchangeservice.exchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ExchangeValueRepository repo;
  @Autowired
  private Environment env;

  @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
    // ExchangeValue val = new
    // ExchangeValue(1L,"USD","INR",BigDecimal.valueOf(70.0));
    ExchangeValue val = repo.findByFromAndTo(from, to);

    val.setPort(Integer.parseInt(env.getProperty("server.port")));

    logger.info("{}", val);

    return val;
  }

}
