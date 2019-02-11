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
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model.ModelMessage;
import com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.repository.RepositoryMessage;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ControllerMessage 
{
	@Autowired
	RepositoryMessage americanFootballRepository;
	
	@PostMapping("/message")
	public ModelMessage createMessage(@Valid @RequestBody ModelMessage mSDM)
	{
		return americanFootballRepository.save(mSDM);
	}
	
	@GetMapping("/message")
	public List<ModelMessage> getAllMessages()
	{
		return americanFootballRepository.findAll();
	}
		
	@GetMapping("/message/{id}")
	public ModelMessage getMessage(@PathVariable(value = "id")Long id)
	{
		return americanFootballRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ModelMessage", "id", id));
	}
	
	@PutMapping("/message/{id}")
	public ModelMessage updateMessage(@PathVariable(value = "id")Long id, @Valid @RequestBody ModelMessage messageDetails)
	{	
		ModelMessage mSDM = americanFootballRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ModelMessage", "id", id));
		
		mSDM.setMessageid(messageDetails.getMessageid());
		mSDM.setUserid1(messageDetails.getUserid());
		mSDM.setUserid1(messageDetails.getUserid1());
		mSDM.setMessage(messageDetails.getMessage());
		
		ModelMessage updateData = americanFootballRepository.save(mSDM);
		return updateData;
	}
	
	@DeleteMapping("/message/{id}")
	public ResponseEntity<?> deleteMessage(@PathVariable(value="id")Long id)
	{	
		ModelMessage mSDM = americanFootballRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("ModelMessage", "id", id));
		
		americanFootballRepository.delete(mSDM);
		return ResponseEntity.ok().build();
	}
}