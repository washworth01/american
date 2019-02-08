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
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.ModelSchedule;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryCoach;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositorySchedule;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ControllerSchedule 
{
	@Autowired
	RepositorySchedule americanFootballRepository;
	
	@PostMapping("/team/schedule")
	public ModelSchedule createCoach(@Valid @ RequestBody ModelSchedule sSDM)
	{
		return americanFootballRepository.save(sSDM);
	}
		
	@GetMapping("/team/schedule/{team_name}")
	public ModelSchedule getCoach(@PathVariable(value = "team_name")String teamName)
	{
		if(americanFootballRepository.findByTeamName(teamName) == null)
		{
			throw new ResourceNotFoundException("AmericanFootballSpringBootModelCoach", "team_name", teamName);
		}
		
		return americanFootballRepository.findByTeamName(teamName);
	}
	
	@PutMapping("/team/schedule/{team_name}")
	public ModelSchedule updateCoach(@PathVariable(value = "team_name")String teamName, @Valid @ RequestBody ModelSchedule teamDetails)
	{
		if(americanFootballRepository.findByTeamName(teamName) == null)
		{
			throw new ResourceNotFoundException("AmericanFootballSpringBootModelCoach", "team_name", teamName);
		}
		
		ModelSchedule sSDM = americanFootballRepository.findByTeamName(teamName);
		
		sSDM.setTeamName(teamDetails.getTeamName());
		sSDM.setDay(teamDetails.getDay());
		sSDM.setStartTime(teamDetails.getStartTime());
		sSDM.setEndTime(teamDetails.getEndTime());
		sSDM.setDescription(teamDetails.getDescription());
		
		ModelSchedule updateData = americanFootballRepository.save(sSDM);
		return updateData;
	}
	
	@DeleteMapping("/team/schedule/{team_name}")
	public ResponseEntity<?> deleteCoach(@PathVariable(value="team_name")String teamName)
	{
		if(americanFootballRepository.findByTeamName(teamName) == null)
		{
			throw new ResourceNotFoundException("AmericanFootballSpringBootModelCoach", "team_name", teamName);
		}
		
		ModelSchedule sSDM = americanFootballRepository.findByTeamName(teamName);
		
		americanFootballRepository.delete(sSDM);
		return ResponseEntity.ok().build();
	}
}