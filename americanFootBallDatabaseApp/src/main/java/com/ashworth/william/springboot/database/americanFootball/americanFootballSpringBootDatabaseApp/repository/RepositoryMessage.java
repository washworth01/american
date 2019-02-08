package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.ModelMessage;

@Repository
public interface RepositoryMessage extends JpaRepository<ModelMessage, Long>
{
	
}
