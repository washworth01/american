//package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;
//
//import java.util.Collection;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//
//@Entity
//@Table(name = "team_detail")
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
//
//public class AmericanFootballSpringBootModelTeamDetail
//{
//	@Id
//	private String teamName;
//	
//	@OneToOne(cascade = CascadeType.ALL, mappedBy="training_contact_details")
//	private AmericanFootballSpringBootModelCoach coach;
//	
//	@OneToOne (cascade = CascadeType.ALL, mappedBy="training_contact_details")
//	private AmericanFootballSpringBootModelContactDetails trainingContactDetails;
//	
//	private String description;
//	
//	public AmericanFootballSpringBootModelTeamDetail()
//	{
//		
//	}
//	
//	public AmericanFootballSpringBootModelTeamDetail(String teamName, AmericanFootballSpringBootModelContactDetails training, AmericanFootballSpringBootModelCoach coach)
//	{
//		this.teamName = teamName;
//		this.coach = coach;
//		this.trainingContactDetails = training;
//	}
//	
//	public AmericanFootballSpringBootModelTeamDetail(String teamName, AmericanFootballSpringBootModelContactDetails training, AmericanFootballSpringBootModelCoach coach, String description)
//	{
//		this.teamName = teamName;
//		this.coach = coach;
//		this.trainingContactDetails = training;
//		this.description = description;
//	}
//
//	public String getTeamName() 
//	{
//		return teamName;
//	}
//
//	public void setTeamName(String teamName)
//	{
//		this.teamName = teamName;
//	}
//
//	public AmericanFootballSpringBootModelCoach getCoach()
//	{
//		return coach;
//	}
//
//	public void setCoach(AmericanFootballSpringBootModelCoach coach) 
//	{
//		this.coach = coach;
//	}
//
//	public AmericanFootballSpringBootModelContactDetails getTrainingContactDetails() 
//	{
//		return trainingContactDetails;
//	}
//
//	public void setTrainingContactDetails(AmericanFootballSpringBootModelContactDetails trainingContactDetails)
//	{
//		this.trainingContactDetails = trainingContactDetails;
//	}
//
//	public String getDescription()
//	{
//		return description;
//	}
//
//	public void setDescription(String description) 
//	{
//		this.description = description;
//	}
//		
//}
