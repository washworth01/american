package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "team_detail")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)

public class AmericanFootballSpringBootModelTeamDetail
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long teamId;
	
	@NotBlank
	private String teamName;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "coach_id")
	private AmericanFootballSpringBootModelCoach coach;
	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "contact_details_id")
	private AmericanFootballSpringBootModelContactDetails contactDetails;
	
	private String description;

	public AmericanFootballSpringBootModelTeamDetail()
	{
		
	}
	
	public AmericanFootballSpringBootModelTeamDetail(Long teamId, @NotBlank String teamName, @NotBlank AmericanFootballSpringBootModelCoach coach,
			@NotBlank AmericanFootballSpringBootModelContactDetails contactDetails, String description) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.coach = coach;
		this.contactDetails = contactDetails;
		this.description = description;
	}
	
	

	public AmericanFootballSpringBootModelTeamDetail(Long teamId, @NotBlank String teamName, @NotBlank AmericanFootballSpringBootModelCoach coach,
			@NotBlank AmericanFootballSpringBootModelContactDetails contactDetails) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.coach = coach;
		this.contactDetails = contactDetails;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
	
	