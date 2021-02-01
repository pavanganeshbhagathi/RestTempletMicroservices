package com.versiontwo.microservices;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchage, Long> {

	CurrencyExchage findByFromAndTo(String from,String to);
	}


