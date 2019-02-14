package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "team_detail")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)

public class AmericanFootballSpringBootModelTeamDetail
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long teamid;
	
	@NotBlank
	private String teamName;

	@ManyToMany(fetch =  FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "player_team", joinColumns = {@JoinColumn(name = "teamid")},
		inverseJoinColumns = {@JoinColumn(name = "playerid")})
	@JsonIgnore
	private Collection<AmericanFootballSpringBootModelPlayer> players = new LinkedHashSet<>();
		
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "coachid")
	private AmericanFootballSpringBootModelCoach coach;
	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "contactdetailsid")
	private AmericanFootballSpringBootModelContactDetails contactDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ModelSchedule modelSchedule; 
	
	private String description;
	
	public AmericanFootballSpringBootModelTeamDetail()
	{
		
	}
	
	public AmericanFootballSpringBootModelTeamDetail(Long teamid, @NotBlank String teamName, @NotBlank AmericanFootballSpringBootModelCoach coach,
			@NotBlank AmericanFootballSpringBootModelContactDetails contactDetails, String description) {
		super();
		this.teamid = teamid;
		this.teamName = teamName;
		this.coach = coach;
		this.contactDetails = contactDetails;
		this.description = description;
	}
	
	

	public AmericanFootballSpringBootModelTeamDetail(Long teamid, @NotBlank String teamName, @NotBlank AmericanFootballSpringBootModelCoach coach,
			@NotBlank AmericanFootballSpringBootModelContactDetails contactDetails) {
		super();
		this.teamid = teamid;
		this.teamName = teamName;
		this.coach = coach;
		this.contactDetails = contactDetails;
	}

	public Long getTeamid() {
		return teamid;
	}

	public void setTeamid(Long teamid) {
		this.teamid = teamid;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public Collection<AmericanFootballSpringBootModelPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(Collection<AmericanFootballSpringBootModelPlayer> players) {
		this.players = players;
	}

	public AmericanFootballSpringBootModelCoach getCoach() {
		return coach;
	}

	public void setCoach(AmericanFootballSpringBootModelCoach coach) {
		this.coach = coach;
	}

	public AmericanFootballSpringBootModelContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(AmericanFootballSpringBootModelContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public ModelSchedule getModelSchedule() {
		return modelSchedule;
	}

	public void setModelSchedule(ModelSchedule modelSchedule) {
		this.modelSchedule = modelSchedule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

	
	