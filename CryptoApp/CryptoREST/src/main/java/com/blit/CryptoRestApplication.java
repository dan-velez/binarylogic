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
import com.blit.repository.MarketRepository;
import com.blit.repository.UserRepository;
import com.blit.entity.Crypto;
import com.blit.entity.Market;
import com.blit.entity.User;

@SpringBootApplication
public class CryptoRestApplication implements CommandLineRunner {
	
	@Autowired
	private CryptoRepository cryptoRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private MarketRepository marketRepo;

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

		String[] links = {"https://alpacafinance.org"};
		List<Market> markets = Arrays.asList(
			new Market("Alpaca", 26938149, 3967355,
				149436269, 149436269,
				188000000, links)
		);

		marketRepo.saveAll(markets);

		userRepo.save(new User("user", // userPass
		"$2y$10$dc3e3saiBRuwAmihOB0cWe8cI./MVgKIrdq9uCukCnRXYoNgYR1e6",
			"USER"));

		userRepo.save(new User("admin", // adminPass
		"$2y$10$VKlPOmlBxacyOtoGuASJuu6F0E4Gf/VfiWsVZSHlr3xHzjn9DQ68W",
			"ADMIN"));
	}

}