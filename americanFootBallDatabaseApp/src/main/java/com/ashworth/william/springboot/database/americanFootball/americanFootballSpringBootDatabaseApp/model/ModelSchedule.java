package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.CascadeType;
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
@Table(name = "schedule")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class ModelSchedule implements Serializable
{
	@Id
	private Long teamId;
	
	@Column
	@NotBlank
	private String day;
	
	@Column
	private Time startTime;
	
	@Column
	private Time endTime;
	
	@Column
	private String description;
	
	public ModelSchedule()
	{
		
	}

	
	
	public ModelSchedule(Long teamId, @NotBlank String day) {
		super();
		this.teamId = teamId;
		this.day = day;
	}

	public ModelSchedule(Long teamId, @NotBlank String day, Time startTime, Time endTime, String description) {
		super();
		this.teamId = teamId;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}