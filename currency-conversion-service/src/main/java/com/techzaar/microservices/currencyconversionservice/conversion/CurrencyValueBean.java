package com.techzaar.microservices.currencyconversionservice.conversion;

import java.math.BigDecimal;

public class CurrencyValueBean {

	int id;
	String from;
	String to;
	BigDecimal conversionMultiple;
	BigDecimal quantity;
	BigDecimal totalCalculatedValue;
	int port;
	
	CurrencyValueBean(){
		
	}
	
	
	public CurrencyValueBean(int id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedValue, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedValue = totalCalculatedValue;
		this.port = port;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedValue() {
		return totalCalculatedValue;
	}
	public void setTotalCalculatedValue(BigDecimal totalCalculatedValue) {
		this.totalCalculatedValue = totalCalculatedValue;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
}
