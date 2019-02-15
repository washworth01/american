package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.exception.ResourceNotFoundException;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.AmericanFootballSpringBootModelTeamMemberKey;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.ModelTeamMember;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryTeamMember;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ControllerTeamMember 
{
	@Autowired
	RepositoryTeamMember americanFootballRepository;
	
	@PostMapping("/team/member")
	public ModelTeamMember createTeamMember(@Valid @ RequestBody ModelTeamMember tMSDM)
	{
		return americanFootballRepository.save(tMSDM);
	}
	
	@GetMapping("/team/member")
	public List<ModelTeamMember> getAllTeamMembers()
	{
		return americanFootballRepository.findAll();
	}
	
//	@GetMapping("/team/member/{team}/{player}")
//	public ModelTeamMember getContactDetails(@PathVariable(value = "team")String teamName, @PathVariable(value = "player") String player)
//	{
//		if(americanFootballRepository.findByTeamAndPlayer(teamName, player) == null)
//		{
//			throw new ResourceNotFoundException("ModelTeamMember", "team", teamName);
//		}
//		
//		return americanFootballRepository.findByTeamAndPlayer(teamName, player);
//	}
//	
//	@PutMapping("/team/member/{team}/{player}")
//	public ModelTeamMember updateTeamMember(@PathVariable(value = "team")String teamName, @PathVariable(value = "player") String player,
//			@Valid @RequestBody ModelTeamMember memberDetails)
//	{
//		if(americanFootballRepository.findByTeamAndPlayer(teamName, player) == null)
//		{
//			throw new ResourceNotFoundException("ModelTeamMember", "team", teamName);
//		}
//		
//		ModelTeamMember tMSDM = americanFootballRepository.findByTeamAndPlayer(teamName, player);
//		
//		tMSDM.setTeam(memberDetails.getTeam());
//		tMSDM.setPlayer(memberDetails.getPlayer());
//		tMSDM.setPlayerNumber(memberDetails.getPlayerNumber());
//		
//		
//		ModelTeamMember updateData = americanFootballRepository.save(tMSDM);
//		return updateData;
//	}
//	
//	@DeleteMapping("/team/member/{team}/{player}")
//	public ResponseEntity<?> deleteTeamMember(@PathVariable(value = "team")String teamName, @PathVariable(value = "player") String player)
//	{		
//		if(americanFootballRepository.findByTeamAndPlayer(teamName, player) == null)
//		{
//			throw new ResourceNotFoundException("ModelTeamMember", "team", teamName);
//		}
//		
//		ModelTeamMember tMSDM = americanFootballRepository.findByTeamAndPlayer(teamName, player);
//		
//		americanFootballRepository.delete(tMSDM);
//		returnResponseEntity.ok().build();
//	}
	
}