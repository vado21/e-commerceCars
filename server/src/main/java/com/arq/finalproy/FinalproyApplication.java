package com.arq.finalproy;

import Repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"routes"})
@EnableMongoRepositories(basePackageClasses=TestRepository.class)
public class FinalproyApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinalproyApplication.class, args);
	}
}
