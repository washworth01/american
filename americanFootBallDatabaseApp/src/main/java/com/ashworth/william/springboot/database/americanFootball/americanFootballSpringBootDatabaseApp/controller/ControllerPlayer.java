package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.exception.ResourceNotFoundException;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelPlayer;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryPlayer;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ControllerPlayer
{
	@Autowired
	RepositoryPlayer americanFootballRepository;
	
	@PostMapping("/user/player")
	public AmericanFootballSpringBootModelPlayer createPlayer(@Valid @ RequestBody AmericanFootballSpringBootModelPlayer pSDM)
	{
		return americanFootballRepository.save(pSDM);
	}
	
	@GetMapping("/user/player")
	public List<AmericanFootballSpringBootModelPlayer> getAllPlayers()
	{
		return americanFootballRepository.findAll();
	}
	
	@GetMapping("/user/player/{username}")
	public AmericanFootballSpringBootModelPlayer getPlayer(@PathVariable(value = "username")String userName)
	{
		if(americanFootballRepository.findByPlayerUsername(userName) == null)
		{
			throw new ResourceNotFoundException("AmericanFootballSpringBootModelPlayer", "username", userName);
		}
		
		return americanFootballRepository.findByPlayerUsername(userName);
	}
	
	@PutMapping("/user/player/{username}")
	public AmericanFootballSpringBootModelPlayer updatePlayer(@PathVariable(value = "username")String userName, @Valid @ RequestBody AmericanFootballSpringBootModelPlayer userDetails)
	{
		if(americanFootballRepository.findByPlayerUsername(userName) == null)
		{
			throw new ResourceNotFoundException("AmericanFootballSpringBootModelPlayer", "username", userName);
		}
		
		AmericanFootballSpringBootModelPlayer pSDM = americanFootballRepository.findByPlayerUsername(userName);
		
		pSDM.setRole(userDetails.getRole());
		pSDM.setPosition(userDetails.getPosition());
		
		AmericanFootballSpringBootModelPlayer updateData = americanFootballRepository.save(pSDM);
		return updateData;
	}
	
	@DeleteMapping("/user/player/{username}")
	public ResponseEntity<?> deletePlayer(@PathVariable(value="username")String userName)
	{
		if(americanFootballRepository.findByPlayerUsername(userName) == null)
		{
			throw new ResourceNotFoundException("AmericanFootballSpringBootModelPlayer", "username", userName);
		}
		
		AmericanFootballSpringBootModelPlayer pSDM = americanFootballRepository.findByPlayerUsername(userName);
		
		americanFootballRepository.delete(pSDM);
		return ResponseEntity.ok().build();
	}
}