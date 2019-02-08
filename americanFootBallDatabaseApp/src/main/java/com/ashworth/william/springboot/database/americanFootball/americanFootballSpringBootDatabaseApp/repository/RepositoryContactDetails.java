package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelContactDetails;

@Repository
public interface RepositoryContactDetails extends JpaRepository<AmericanFootballSpringBootModelContactDetails, Long>
{
	public AmericanFootballSpringBootModelContactDetails findByPostcodeAndHouseNumber(String postcode, String houseNumber);
}
