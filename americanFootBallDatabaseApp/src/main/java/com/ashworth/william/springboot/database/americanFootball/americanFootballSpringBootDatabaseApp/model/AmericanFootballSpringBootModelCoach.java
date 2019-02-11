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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "coach")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class AmericanFootballSpringBootModelCoach
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long coachid;
		
	@NotBlank
	private String trainingSpecialisation;
	
	@OneToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "userid", nullable=false)
	@JsonIgnore
	private AmericanFootballSpringBootModelUser user;

	public AmericanFootballSpringBootModelCoach()
	{
		
	}

	public AmericanFootballSpringBootModelCoach(Long coachid, @NotBlank String trainingSpecialisation,
	AmericanFootballSpringBootModelUser user) {
		super();
		this.coachid = coachid;
		this.trainingSpecialisation = trainingSpecialisation;
		this.user = user;
	}

	public Long getCoachId() {
		return coachid;
	}

	public void setCoachId(Long coachid) {
		this.coachid = coachid;
	}

	public String getTrainingSpecialisation() {
		return trainingSpecialisation;
	}

	public void setTrainingSpecialisation(String trainingSpecialisation) {
		this.trainingSpecialisation = trainingSpecialisation;
	}

}
