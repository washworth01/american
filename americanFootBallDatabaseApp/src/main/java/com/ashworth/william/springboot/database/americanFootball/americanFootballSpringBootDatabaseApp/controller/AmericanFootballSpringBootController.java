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
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModel;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelUser;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.AmericanFootballSpringBootRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AmericanFootballSpringBootController 
{
	@Autowired
	AmericanFootballSpringBootRepository americanFootballRepository;
	
	@PostMapping("/user")
	public AmericanFootballSpringBootModelUser createUser(@Valid @ RequestBody AmericanFootballSpringBootModelUser bSDM)
	{
		return americanFootballRepository.save(bSDM);
	}
	
//	@GetMapping("/user/{usename}")
//	public AmericanFootballSpringBootModelUser getFilmID(@PathVariable("id")Long filmID)
//	{
//		return americanFootballRepository.findById(filmID).orElseThrow(()-> new ResourceNotFoundException("AmericanFootballSpringBootModel", "id", filmID));
//	}
//	
//	@GetMapping("/user/title/{title}")
//	public List<AmericanFootballSpringBootModelUser> getFilmTitle(@PathVariable(value ="title")String filmTitle)
//	{	
//		if(americanFootballRepository.findByTitle(filmTitle) == null)
//		{
//			throw new ResourceNotFoundException("AmericanFootballSpringBootModel", "title", filmTitle);
//		}
//		
//		return americanFootballRepository.findByTitle(filmTitle);
//		
//	}
//
//	@GetMapping("/film/category/{category}")
//	public List<AmericanFootballSpringBootModelUser> getFilmCategory(@PathVariable(value ="category")String filmCategory)
//	{
//		if(americanFootballRepository.findByCategory(filmCategory) == null)
//		{
//			throw new ResourceNotFoundException("AmericanFootballSpringBootModel", "category", filmCategory);
//		}
//		
//		return americanFootballRepository.findByCategory(filmCategory);
//	}
//		
//	@GetMapping("/film/rating/{rating}")
//	public List<AmericanFootballSpringBootModelUser> getFilmRating(@PathVariable(value ="rating")String filmRating)
//	{
//		if(americanFootballRepository.findByRating(filmRating) == null)
//		{
//			throw new ResourceNotFoundException("AmericanFootballSpringBootModel", "category", filmRating);
//		}
//		
//		return americanFootballRepository.findByRating(filmRating);
//	}

//	@GetMapping("/user")
//	public List<AmericanFootballSpringBootModelUser> getAllFilm()
//	{
//		return americanFootballRepository.findAll();
//	}
// 
//	@PutMapping("/user/{username}")
//	public AmericanFootballSpringBootModelUser updateFilm(@PathVariable("id")Long filmID, @Valid @RequestBody AmericanFootballSpringBootModelUser filmDetails)
//	{
//		AmericanFootballSpringBootModelUser bSDM = americanFootballRepository.findById(filmID).orElseThrow(()-> new ResourceNotFoundException("AmericanFootballSpringBootModel", "id", filmID));
//		 
//		bSDM.setTitle(filmDetails.getTitle());
//		bSDM.setDescription(filmDetails.getDescription());
//		bSDM.setCategory(filmDetails.getCategory());
//		bSDM.setPrice(filmDetails.getPrice());
//		bSDM.setLength(filmDetails.getLength());
//		bSDM.setRating(filmDetails.getRating());
//		
//		AmericanFootballSpringBootModelUser updateData = americanFootballRepository.save(bSDM);
//		return updateData;
//	}
//
//	@DeleteMapping("/user/{username}")
//	public ResponseEntity<?> deleteVehicle(@PathVariable("id")Long vehicleID)
//	{
//		AmericanFootballSpringBootModelUser bSDM = americanFootballRepository.findById(vehicleID).orElseThrow(()-> new ResourceNotFoundException("AmericanFootballSpringBootModel", "id", vehicleID));
//	
//		americanFootballRepository.delete(bSDM);
//		return ResponseEntity.ok().build();
//	}
}

