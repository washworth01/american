package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AmericanFootballSpringBootDatabaseAppApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(AmericanFootballSpringBootDatabaseAppApplication.class, args);
	}
}
