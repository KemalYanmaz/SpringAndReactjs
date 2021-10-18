package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.business.abstracts.CountryService;
import com.example.demo.entities.concretes.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
public class CountriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CountryService countryService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			TypeReference<List<Country>> typeReference = new TypeReference<List<Country>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/restcountries.json");
			try {
				List<Country> users = mapper.readValue(inputStream,typeReference);
				countryService.addAll(users);
				System.out.println("Countries Saved!");
			} catch (IOException e){
				System.out.println("Unable to save countries: " + e.getMessage());
			}
		};
	}
}
