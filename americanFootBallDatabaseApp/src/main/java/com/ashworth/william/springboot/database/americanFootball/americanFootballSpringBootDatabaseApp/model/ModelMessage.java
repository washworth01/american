package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "message")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class ModelMessage
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long messageid;
	
	@ManyToOne(fetch = FetchType.EAGER, optional= false)
	@JoinColumn(name = "userid", nullable=false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private AmericanFootballSpringBootModelUser userid;
	
	@ManyToOne(fetch = FetchType.EAGER, optional= false)
	@JoinColumn(name = "userid1", nullable=false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private AmericanFootballSpringBootModelUser userid1;
	
	@NotBlank
	@Column
	private String message;
	
	public ModelMessage()
	{
		
	}
	
	public ModelMessage(AmericanFootballSpringBootModelUser userid, AmericanFootballSpringBootModelUser userid1, String message)
	{
		super();
		this.userid = userid;
		this.userid1 = userid1;
		this.message = message;
	}

	public Long getMessageid() {
		return messageid;
	}

	public void setMessageid(Long messageid) {
		this.messageid = messageid;
	}

	public AmericanFootballSpringBootModelUser getUserid() {
		return userid;
	}

	public void setUserid(AmericanFootballSpringBootModelUser userid) {
		this.userid = userid;
	}

	public AmericanFootballSpringBootModelUser getUserid1() {
		return userid1;
	}

	public void setUserid1(AmericanFootballSpringBootModelUser userid1) {
		this.userid1 = userid1;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}