package com.techzaar.microservices.currencyexchangeservice.exchange;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	public ExchangeValue findByFromAndTo(String from, String to);
}
