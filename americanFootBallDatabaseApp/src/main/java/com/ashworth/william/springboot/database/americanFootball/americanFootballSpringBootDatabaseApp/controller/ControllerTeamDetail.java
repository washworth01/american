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
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelTeamDetail;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryTeamDetail;

@CrossOrigin
@RestController
@RequestMapping("/api") 
public class ControllerTeamDetail
{
	@Autowired
	RepositoryTeamDetail americanFootballRepository;
	
	@PostMapping("/team_detail")
	public AmericanFootballSpringBootModelTeamDetail createTeam(@Valid @ RequestBody AmericanFootballSpringBootModelTeamDetail tDSDM)
	{
		return americanFootballRepository.save(tDSDM);
	}
	
	@GetMapping("/team_detail")
	public List<AmericanFootballSpringBootModelTeamDetail> getAllTeams()
	{
		return americanFootballRepository.findAll();
	}
	
	@GetMapping("/team_detail/{team_name}")
	public AmericanFootballSpringBootModelTeamDetail getTeam(@PathVariable(value = "teamName")String teamName)
	{
		if(americanFootballRepository.findByTeamName(teamName) == null)
		{
			throw new ResourceNotFoundException("AmericanFootballSpringBootModelTeamDetail", "teamName", teamName);
		}
		
		return americanFootballRepository.findByTeamName(teamName);
	}
	
	@PutMapping("/team_detail/{team_name}")
	public AmericanFootballSpringBootModelTeamDetail updateTeam(@PathVariable(value = "teamName")String teamName, @Valid @ RequestBody AmericanFootballSpringBootModelTeamDetail teamDetails)
	{
		if(americanFootballRepository.findByTeamName(teamName) == null)
		{
			throw new ResourceNotFoundException("AmericanFootballSpringBootModelTeamDetail", "teamName", teamName);
		}
		
		AmericanFootballSpringBootModelTeamDetail tDSDM = americanFootballRepository.findByTeamName(teamName);
		
		tDSDM.setTeamName(teamDetails.getTeamName());
		tDSDM.setCoach(teamDetails.getCoach());
		tDSDM.setTrainingContactDetails(teamDetails.getTrainingContactDetails());
		tDSDM.setDescription(teamDetails.getDescription());
		
		AmericanFootballSpringBootModelTeamDetail updateData = americanFootballRepository.save(tDSDM);
		return updateData;
	}
	
	@DeleteMapping("/team_detail/{team_name}")
	public ResponseEntity<?> deleteTeam(@PathVariable(value="teamName")String teamName)
	{
		if(americanFootballRepository.findByTeamName(teamName) == null)
		{
			throw new ResourceNotFoundException("AmericanFootballSpringBootModelTeamDetail", "teamName", teamName);
		}
		
		AmericanFootballSpringBootModelTeamDetail tDSDM = americanFootballRepository.findByTeamName(teamName);
		
		americanFootballRepository.delete(tDSDM);
		return ResponseEntity.ok().build();
	}
}