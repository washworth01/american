package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "coach")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class AmericanFootballSpringBootModelCoach implements Serializable
{
	@Id
	@OneToOne(cascade = CascadeType.ALL, mappedBy="AmericanFootballSpringBootModelUser")
	@Column (name = "coach_username") private String coachUsername;
		
	@NotBlank
	@Column (name = "training_specialistaion") private String specialisation;
	
	public AmericanFootballSpringBootModelCoach()
	{
		
	}
		
	public AmericanFootballSpringBootModelCoach(String coachUsername, String specialisation)
	{
		this.coachUsername = coachUsername;
		this.specialisation = specialisation;
	}

	public String getCoachUsername() 
	{
		return coachUsername;
	}

	public void setCoachUsername(String coach_username) 
	{
		this.coachUsername = coach_username;
	}

	public String getSpecialisation() 
	{
		return specialisation;
	}

	public void setSpecialisation(String specialisation) 
	{
		this.specialisation = specialisation;
	}
		
}
