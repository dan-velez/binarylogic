package com.blit;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blit.repository.CryptoRepository;
import com.blit.entity.Crypto;

@SpringBootApplication
public class CryptoRestApplication implements CommandLineRunner {
	
	@Autowired
	private CryptoRepository cryptoRepo;

	private static final Logger logger = LoggerFactory.getLogger(
		CryptoRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CryptoRestApplication.class, args);
		logger.info("Application started.");
	}

	@Override
	public void run(String... args) throws Exception {
		List<Crypto> cryptos = Arrays.asList(
			new Crypto("BTC/USD", "2024-04-22:12:00:00T",
			 66231.00, 66231.00,
			66231.00, 66231.00, 2.33)
		);

		cryptoRepo.saveAll(cryptos);
	}

}