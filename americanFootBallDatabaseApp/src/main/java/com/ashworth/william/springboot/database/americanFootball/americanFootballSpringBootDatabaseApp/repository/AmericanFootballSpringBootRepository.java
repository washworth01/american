package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelUser;

@Repository
public interface AmericanFootballSpringBootRepository extends JpaRepository<AmericanFootballSpringBootModelUser, Long>
{
//	List<AmericanFootballSpringBootModelUser> findByTitle(String filmTitle);
//	List<AmericanFootballSpringBootModelUser> findByCategory(String filmCategory);
//	List<AmericanFootballSpringBootModelUser> findByRating(String filmRating);
}
