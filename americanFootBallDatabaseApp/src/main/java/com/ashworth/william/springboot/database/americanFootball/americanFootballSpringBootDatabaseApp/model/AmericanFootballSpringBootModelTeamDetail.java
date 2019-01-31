package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Id;

@Entity
@Table(name = "team_detail")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)

public class AmericanFootballSpringBootModelTeamDetail
{
	@Id
	@Column(name = "team_name") private String teamName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coach_username", nullable = false)
	private AmericanFootballSpringBootModelCoach coach;
	
	@OneToOne
	
		
}
