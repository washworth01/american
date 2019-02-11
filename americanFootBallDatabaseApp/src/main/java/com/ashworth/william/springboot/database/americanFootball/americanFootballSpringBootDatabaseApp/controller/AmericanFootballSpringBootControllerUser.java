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
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelUser;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryUser;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AmericanFootballSpringBootControllerUser 
{
	@Autowired
	RepositoryUser americanFootballRepository;
	
	@PostMapping("/user")
	public AmericanFootballSpringBootModelUser creatUser(@Valid @RequestBody AmericanFootballSpringBootModelUser uSDM)
	{
		return americanFootballRepository.save(uSDM);
	}
	
	@GetMapping("/user")
	public List<AmericanFootballSpringBootModelUser> getAllUsers()
	{
		return americanFootballRepository.findAll();
	}
		
	@GetMapping("/user/{id}")
	public AmericanFootballSpringBootModelUser getUser(@PathVariable(value = "id")Long id)
	{
		return americanFootballRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AmericanFootballSpringBootModelUser", "id", id));
	}
	
	@PutMapping("/user/{id}")
	public AmericanFootballSpringBootModelUser updateUser(@PathVariable(value = "id")Long id, @Valid @RequestBody AmericanFootballSpringBootModelUser userDetails)
	{	
		AmericanFootballSpringBootModelUser uSDM = americanFootballRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AmericanFootballSpringBootModelUser", "id", id));
		
		uSDM.setUsername(userDetails.getUsername());
		uSDM.setPassword(userDetails.getPassword());
		uSDM.setFirstName(userDetails.getFirstName());
		uSDM.setLastName(userDetails.getLastName());
		uSDM.setEmailAddress(userDetails.getEmailAddress());
		uSDM.setDateOfBirth(userDetails.getDateOfBirth());
		uSDM.setDescription(userDetails.getDescription());

		AmericanFootballSpringBootModelUser updateData = americanFootballRepository.save(uSDM);
		return updateData;
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value="id")Long id)
	{	
		AmericanFootballSpringBootModelUser uSDM = americanFootballRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AmericanFootballSpringBootModelUser", "id", id));
		
		americanFootballRepository.delete(uSDM);
		return ResponseEntity.ok().build();
	}
}