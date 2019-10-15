package com.techbow.datadashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DataDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataDashboardApplication.class, args);
	}

}
