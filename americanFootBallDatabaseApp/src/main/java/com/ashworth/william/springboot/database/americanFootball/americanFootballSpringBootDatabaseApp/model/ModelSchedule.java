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
import javax.persistence.MapsId;
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
	@Column(name = "teamid")
	private Long teamid;
	
	@MapsId
	@OneToOne(mappedBy = "modelSchedule")
	@JoinColumn(name = "teamid")
	private AmericanFootballSpringBootModelTeamDetail team;
	
	@Column
	@NotBlank
	private String days;
	
	@Column
	private Time startTime;
	
	@Column
	private Time endTime;
	
	@Column
	private String description;
	
	public ModelSchedule()
	{
		
	}

	
	
	public ModelSchedule(Long teamid, @NotBlank String days) {
		super();
		this.teamid = teamid;
		this.days = days;
	}

	public ModelSchedule(Long teamid, @NotBlank String days, Time startTime, Time endTime, String description) {
		super();
		this.teamid = teamid;
		this.days = days;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
	}

	public Long getTeamId() {
		return teamid;
	}

	public void setTeamId(Long teamid) {
		this.teamid = teamid;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String day) {
		this.days = day;
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