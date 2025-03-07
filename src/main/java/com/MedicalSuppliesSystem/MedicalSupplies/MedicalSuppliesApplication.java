package com.MedicalSuppliesSystem.MedicalSupplies;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MedicalSuppliesApplication {

	public static Logger logger = LoggerFactory.getLogger(MedicalSuppliesApplication.class);

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@PostConstruct
	public void method ()
	{
		logger.info("testing is executing");
	}
	public static void main(String[] args) {
		logger.info("Application is started");
		SpringApplication.run(MedicalSuppliesApplication.class, args);
	}

}
