package com.machado.MedSync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MedSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedSyncApplication.class, args);
	}

}
