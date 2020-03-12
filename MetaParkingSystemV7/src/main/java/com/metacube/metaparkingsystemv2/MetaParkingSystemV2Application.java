package com.metacube.metaparkingsystemv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.metacube.metaparkingsystemv2.dao.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class MetaParkingSystemV2Application {

	public static void main(String[] args) {
		SpringApplication.run(MetaParkingSystemV2Application.class, args);
	}
}
