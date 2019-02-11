package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long coachId;
		
	@NotBlank
	private String trainingSpecialisation;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private AmericanFootballSpringBootModelUser user;

	public AmericanFootballSpringBootModelCoach()
	{
		
	}

	public AmericanFootballSpringBootModelCoach(Long coachId, @NotBlank String trainingSpecialisation,
			@NotBlank AmericanFootballSpringBootModelUser user) {
		super();
		this.coachId = coachId;
		this.trainingSpecialisation = trainingSpecialisation;
		this.user = user;
	}

	public Long getCoachId() {
		return coachId;
	}

	public void setCoachId(Long coachId) {
		this.coachId = coachId;
	}

	public String getTrainingSpecialisation() {
		return trainingSpecialisation;
	}

	public void setTrainingSpecialisation(String trainingSpecialisation) {
		this.trainingSpecialisation = trainingSpecialisation;
	}

}
