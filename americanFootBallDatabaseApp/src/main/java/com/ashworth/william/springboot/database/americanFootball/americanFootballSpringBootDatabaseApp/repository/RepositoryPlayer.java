package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelPlayer;

@Repository
public interface RepositoryPlayer extends JpaRepository<AmericanFootballSpringBootModelPlayer, Long>
{
	AmericanFootballSpringBootModelPlayer findByPlayerUsername(String playerUsername);
}
