package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "player_team")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class ModelTeamMember implements Serializable
{
	@EmbeddedId
	private AmericanFootballSpringBootModelTeamMemberKey id;
	
	private Integer playerNumber;
	
	public ModelTeamMember()
	{
		
	}
	
	public ModelTeamMember(AmericanFootballSpringBootModelTeamMemberKey id)
	{
		this.id = id;
	}
	
	public ModelTeamMember(AmericanFootballSpringBootModelTeamMemberKey id, Integer playerNumber)
	{
		this.id = id;
		this.playerNumber = playerNumber;
	}

	public AmericanFootballSpringBootModelTeamMemberKey getId() {
		return id;
	}

	public void setId(AmericanFootballSpringBootModelTeamMemberKey id) {
		this.id = id;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(Integer playerNumber) {
		this.playerNumber = playerNumber;
	}
}