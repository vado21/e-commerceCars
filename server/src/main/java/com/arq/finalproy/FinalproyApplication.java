package com.arq.finalproy;

import Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"routes"})
@EnableMongoRepositories(basePackageClasses=CarRepository.class)
public class FinalproyApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinalproyApplication.class, args);
	}
}
