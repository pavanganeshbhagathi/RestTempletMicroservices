package com.versiontwo.microservices.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents.UriTemplateVariables;

@RestController
public class CurrencyConversionController {

	
	@Autowired
	private Environment environment;

	// http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{exchangemoneyamount}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal exchangemoneyamount) {
		

		HashMap<String, String> UriVariables = new HashMap<>();
		UriVariables.put("from", from);
		UriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, UriVariables);

		CurrencyConversion res = responseEntity.getBody();
		
		   BigDecimal totalCost = res.getConversionMultiple().multiply(exchangemoneyamount); 
		      CurrencyConversion currencyConversion = new CurrencyConversion(res.getId(),from,to,exchangemoneyamount,res.getConversionMultiple(),totalCost,res.getEnviroment());

		return currencyConversion;
	}
}
