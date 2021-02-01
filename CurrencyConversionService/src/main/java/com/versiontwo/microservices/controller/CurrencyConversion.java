package com.versiontwo.microservices.controller;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class CurrencyConversion {

	private Long id;
	private String from;
	private String to;
	private BigDecimal quntity;
	private BigDecimal conversionMultiple;
	private BigDecimal totalCostAmount;
	
	public CurrencyConversion() {
		
	}
	public CurrencyConversion(Long id, String from, String to, BigDecimal quntity, BigDecimal conversionMultiple,
			BigDecimal totalCostAmount, String enviroment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quntity = quntity;
		this.conversionMultiple = conversionMultiple;
		this.totalCostAmount = totalCostAmount;
		this.enviroment = enviroment;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public BigDecimal getQuntity() {
		return quntity;
	}
	public void setQuntity(BigDecimal quntity) {
		this.quntity = quntity;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getTotalCostAmount() {
		return totalCostAmount;
	}
	public void setTotalCostAmount(BigDecimal totalCostAmount) {
		this.totalCostAmount = totalCostAmount;
	}
	public String getEnviroment() {
		return enviroment;
	}
	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}
	private String enviroment;

}
