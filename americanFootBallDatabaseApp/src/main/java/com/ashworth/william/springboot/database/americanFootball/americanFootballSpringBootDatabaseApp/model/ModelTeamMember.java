package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "team_member")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class ModelTeamMember implements Serializable
{
	
	@Id
	@ManyToOne
	@JoinColumn
	private AmericanFootballSpringBootModelTeamDetail team;
	
	@Id
	@ManyToOne
	@JoinColumn
	private AmericanFootballSpringBootModelPlayer player;
	
	@NotBlank
	@Column
	private int playerNumber;
	
	public ModelTeamMember()
	{
		
	}
	
	public ModelTeamMember(AmericanFootballSpringBootModelTeamDetail team ,AmericanFootballSpringBootModelPlayer player, int playerNumber)
	{
		this.team = team;
		this.player = player;
		this.playerNumber = playerNumber;
	}

	public AmericanFootballSpringBootModelTeamDetail getTeam()
	{
		return team;
	}

	public void setTeam(AmericanFootballSpringBootModelTeamDetail team) 
	{
		this.team = team;
	}

	public AmericanFootballSpringBootModelPlayer getPlayer() 
	{
		return player;
	}

	public void setPlayer(AmericanFootballSpringBootModelPlayer player)
	{
		this.player = player;
	}

	public int getPlayerNumber()
	{
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber)
	{
		this.playerNumber = playerNumber;
	}
	
	
}