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
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelContactDetails;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryContactDetails;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ControllerContactDetails 
{
	@Autowired
	RepositoryContactDetails americanFootballRepository;
	
	@PostMapping("/contact")
	public AmericanFootballSpringBootModelContactDetails createContactDetails(@Valid @ RequestBody AmericanFootballSpringBootModelContactDetails cDSDM)
	{
		return americanFootballRepository.save(cDSDM);
	}
	
	@GetMapping("/contact")
	public List<AmericanFootballSpringBootModelContactDetails> getAllContactDetails()
	{
		return americanFootballRepository.findAll();
	}
	
	@GetMapping("/contact/{id}")
	public AmericanFootballSpringBootModelContactDetails getContactDetails(@PathVariable(value = "id")Long id)
	{	
		return americanFootballRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AmericanFootballSpringBootModelContactDetails", "id", id));
	}
	
	@PutMapping("/contact/{id}")
	public AmericanFootballSpringBootModelContactDetails updateContactDetails(@PathVariable(value = "id")Long id,
			@Valid @RequestBody AmericanFootballSpringBootModelContactDetails contactDetails)
	{
		AmericanFootballSpringBootModelContactDetails cDSDM = americanFootballRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AmericanFootballSpringBootModelContactDetails", "id", id));
		
		cDSDM.setPostcode(contactDetails.getPostcode());
		cDSDM.setHouseNumber(contactDetails.getHouseNumber());
		cDSDM.setAddressLine1(contactDetails.getAddressLine1());
		cDSDM.setAddressLine2(contactDetails.getAddressLine2());
		cDSDM.setCity(contactDetails.getCity());
		cDSDM.setCounty(contactDetails.getCounty());
		cDSDM.setPhoneNumber(contactDetails.getPhoneNumber());		
		
		AmericanFootballSpringBootModelContactDetails updateData = americanFootballRepository.save(cDSDM);
		return updateData;
	}
	
	@DeleteMapping("/contact/{id}")
	public ResponseEntity<?> deleteContactDetails(@PathVariable(value = "id")Long id)
	{		
		
		AmericanFootballSpringBootModelContactDetails cDSDM = americanFootballRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("AmericanFootballSpringBootModelContactDetails", "id", id));
		
		americanFootballRepository.delete(cDSDM);
		return ResponseEntity.ok().build();
	}
}