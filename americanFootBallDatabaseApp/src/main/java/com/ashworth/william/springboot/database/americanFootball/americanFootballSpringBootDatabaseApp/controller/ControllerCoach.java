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
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelCoach;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryCoach;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ControllerCoach 
{
	@Autowired
	RepositoryCoach americanFootballRepository;
	
	@PostMapping("/coach")
	public AmericanFootballSpringBootModelCoach createCoach(@Valid @ RequestBody AmericanFootballSpringBootModelCoach cSDM)
	{
		return americanFootballRepository.save(cSDM);
	}
	
	@GetMapping("/coach")
	public List<AmericanFootballSpringBootModelCoach> getAllCoach()
	{
		return americanFootballRepository.findAll();
	}
//	
//	@GetMapping("/user/coach/{username}")
//	public AmericanFootballSpringBootModelCoach getCoach(@PathVariable(value = "username")String userName)
//	{
//		if(americanFootballRepository.findByCoachUsername(userName) == null)
//		{
//			throw new ResourceNotFoundException("AmericanFootballSpringBootModelCoach", "username", userName);
//		}
//		
//		return americanFootballRepository.findByCoachUsername(userName);
//	}
//	
//	@PutMapping("/user/coach/{username}")
//	public AmericanFootballSpringBootModelCoach updateCoach(@PathVariable(value = "username")String userName, @Valid @ RequestBody AmericanFootballSpringBootModelCoach userDetails)
//	{
//		if(americanFootballRepository.findByCoachUsername(userName) == null)
//		{
//			throw new ResourceNotFoundException("AmericanFootballSpringBootModelCoach", "username", userName);
//		}
//		
//		AmericanFootballSpringBootModelCoach cSDM = americanFootballRepository.findByCoachUsername(userName);
//		
//		cSDM.setSpecialisation(userDetails.getSpecialisation());
//		
//		AmericanFootballSpringBootModelCoach updateData = americanFootballRepository.save(cSDM);
//		return updateData;
//	}
//	
//	@DeleteMapping("/user/coach/{username}")
//	public ResponseEntity<?> deleteCoach(@PathVariable(value="username")String userName)
//	{
//		if(americanFootballRepository.findByCoachUsername(userName) == null)
//		{
//			throw new ResourceNotFoundException("AmericanFootballSpringBootModelCoach", "username", userName);
//		}
//		
//		AmericanFootballSpringBootModelCoach cSDM = americanFootballRepository.findByCoachUsername(userName);
//		
//		americanFootballRepository.delete(cSDM);
//		return ResponseEntity.ok().build();
//	}
}