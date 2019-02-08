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
@Table(name = "player")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class AmericanFootballSpringBootModelPlayer implements Serializable
{
	@Id
	@OneToOne(cascade = CascadeType.ALL, mappedBy="AmericanFootballSpringBootModelUser")
	@Column (name = "player_username") private String playerUsername;
		
	@NotBlank
	@Column 
	private String role;
	
	@NotBlank
	@Column (name = "prefered_position") private String position;
	
	
	public AmericanFootballSpringBootModelPlayer()
	{
		
	}
		
	public AmericanFootballSpringBootModelPlayer(String playerUsername, String role, String position)
	{
		this.playerUsername = playerUsername;
		this.role = role;
		this.position = position;
	}

	public String getPlayerUsername()
	{
		return playerUsername;
	}

	public void setPlayerUsername(String player_username)
	{
		this.playerUsername = player_username;
	}

	public String getRole() 
	{
		return role;
	}

	public void setRole(String role) 
	{
		this.role = role;
	}
	
	public String getPosition() 
	{
		return position;
	}

	public void setPosition(String position) 
	{
		this.position = position;
	}
		
}
