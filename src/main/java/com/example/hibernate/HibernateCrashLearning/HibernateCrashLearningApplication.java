package com.example.hibernate.HibernateCrashLearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableJpaRepositories
@EntityScan(basePackages = "com.example.hibernate.HibernateCrashLearning.entity")
public class HibernateCrashLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateCrashLearningApplication.class, args);
	}

}
