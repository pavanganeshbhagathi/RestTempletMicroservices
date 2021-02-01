package com.versiontwo.microservices;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeServiceContoller {

	@Autowired
	private Environment env;
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	// currency-exchange/from/USD/to/INR
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchage retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchage currencyExchange = new CurrencyExchage(1000L, from, to, BigDecimal.valueOf(50));

		String port = env.getProperty("local.server.port");

		
		CurrencyExchage findByFromANDTo = currencyExchangeRepository.findByFromAndTo(from, to);
		findByFromANDTo.setEnviroment(port);
		return findByFromANDTo;
	}

}
