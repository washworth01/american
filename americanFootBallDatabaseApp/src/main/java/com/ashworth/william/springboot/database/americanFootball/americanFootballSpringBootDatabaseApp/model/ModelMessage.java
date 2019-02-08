package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "message")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class ModelMessage implements Serializable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long message_id;
	
	@ManyToOne
	@JoinColumn
	private AmericanFootballSpringBootModelUser sender;
	
	@ManyToOne
	@JoinColumn
	private AmericanFootballSpringBootModelUser receiver;
	
	@NotBlank
	@Column
	private String message;
	
	public ModelMessage()
	{
		
	}
	
	public ModelMessage(AmericanFootballSpringBootModelUser sender, AmericanFootballSpringBootModelUser receiver, String message)
	{
		this.sender = sender;
		this.receiver = receiver;
		this.message = message;
	}

	public Long getMessage_id() 
	{
		return message_id;
	}

	public void setMessage_id(Long message_id) 
	{
		this.message_id = message_id;
	}

	public AmericanFootballSpringBootModelUser getSender() 
	{
		return sender;
	}

	public void setSender(AmericanFootballSpringBootModelUser sender) 
	{
		this.sender = sender;
	}

	public AmericanFootballSpringBootModelUser getReceiver() 
	{
		return receiver;
	}

	public void setReceiver(AmericanFootballSpringBootModelUser receiver) 
	{
		this.receiver = receiver;
	}

	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
	
}