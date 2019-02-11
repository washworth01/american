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
	private Long messageId;
	
	@NotBlank
	private Long senderId;
	
	@NotBlank
	private Long receiverId;
	
	@NotBlank
	@Column
	private String message;
	
	public ModelMessage()
	{
		
	}
	
	public ModelMessage(Long senderId, Long receiverId, String message)
	{
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.message = message;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Long getSender() {
		return senderId;
	}

	public void setSender(Long senderId) {
		this.senderId = senderId;
	}

	public Long getReceiver() {
		return receiverId;
	}

	public void setReceiver(Long receiverId) {
		this.receiverId = receiverId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}