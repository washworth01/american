package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "player")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class AmericanFootballSpringBootModelPlayer implements Serializable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long playerid;
	
	@OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private AmericanFootballSpringBootModelUser user;
		
	@NotBlank
	private String preferedRole;
	
	@NotBlank
	private String preferedPosition;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE}, mappedBy = "players")
	private Collection<AmericanFootballSpringBootModelTeamDetail> teams = new LinkedHashSet<>();
	
	public AmericanFootballSpringBootModelPlayer()
	{
		
	}
		
	public AmericanFootballSpringBootModelPlayer(String preferedRole, String preferedPosition, AmericanFootballSpringBootModelUser user)
	{
		this.preferedRole = preferedRole;
		this.preferedPosition = preferedPosition;
		this.user = user;
	}

	public Long getPlayerId() {
		return playerid;
	}

	public void setPlayerId(Long playerid) {
		this.playerid = playerid;
	}

	public String getPreferedRole() {
		return preferedRole;
	}

	public void setPreferedRole(String preferedRole) {
		this.preferedRole = preferedRole;
	}

	public String getPreferedPosition() {
		return preferedPosition;
	}

	public void setPreferedPosition(String preferedPosition) {
		this.preferedPosition = preferedPosition;
	}

	public AmericanFootballSpringBootModelUser getUser() {
		return user;
	}

	public void setUser(AmericanFootballSpringBootModelUser user) {
		this.user = user;
	}
		
	public Long getPlayerid() {
		return playerid;
	}

	public void setPlayerid(Long playerid) {
		this.playerid = playerid;
	}

	public Collection<AmericanFootballSpringBootModelTeamDetail> getTeams() {
		return teams;
	}

	public void setTeams(Collection<AmericanFootballSpringBootModelTeamDetail> teams) {
		this.teams = teams;
	}

}
