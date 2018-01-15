package org.sambasoft;

import org.sambasoft.entities.Country;
import org.sambasoft.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SambasoftApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	@Override
	public void run(String...args) throws Exception {
		countryRepository.save(new Country("Czech Republic", "Prague"));
		countryRepository.save(new Country("France", "Paris"));
		countryRepository.save(new Country("Germany", "Berlin"));
		countryRepository.save(new Country("UK", "London"));
		countryRepository.save(new Country("China", "Beijin"));
		countryRepository.save(new Country("Hungary", "Budapest"));
		countryRepository.save(new Country("Russia", "Moscow"));
		countryRepository.save(new Country("Italy", "Rome"));
		countryRepository.save(new Country("Ukraina", "Kiew"));
		countryRepository.save(new Country("Serbia", "Belgrade"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SambasoftApplication.class, args);
	}
}
