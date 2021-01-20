package com.aaronlewis.justusbackend;

import com.aaronlewis.justusbackend.entities.AccountOwner;
import com.aaronlewis.justusbackend.repositories.AccountOwnerRepository;
import com.aaronlewis.justusbackend.repositories.EmailRepository;
import com.aaronlewis.justusbackend.repositories.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.Calendar;

@SpringBootApplication
public class JustUsBackendApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	LoginRepository personRepo;
	@Autowired
	AccountOwnerRepository accountRepo;
	@Autowired
	EmailRepository emailRepo;

	public static void main(String[] args) {
		SpringApplication.run(JustUsBackendApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		logger.info("Looking for nonexistent email -> {}", emailRepo.findByEmail("test@email.com"));
		Calendar calendar = Calendar.getInstance();
		calendar.set(1991, 6, 24);
		logger.info("Deleting previous entry");
		accountRepo.deleteById(1L);
		logger.info("Creating new Account -> {}",
				accountRepo.insert(new AccountOwner(
						"aaron@mail.com", "Aaron", "Lewis",
						new Date(calendar.getTimeInMillis()))));
	}

}
