package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.type.DateType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class AmericanFootballSpringBootModelUser implements Serializable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long userid;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String emailAddress;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@JsonFormat(pattern="yyyy-MM-dd")
    private String dateOfBirth; 

	private String description;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contactdetailsid")
	private AmericanFootballSpringBootModelContactDetails contactdetails;
			
	public AmericanFootballSpringBootModelUser()
	{
		
	} 

	public AmericanFootballSpringBootModelUser(String username, String password,
			 String emailAddress,  String firstName,  String lastName,
			 String dateOfBirth, String description, AmericanFootballSpringBootModelContactDetails contactdetails) {
		super();
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.description = description;
		this.contactdetails = contactdetails;
	}
	
	public AmericanFootballSpringBootModelUser(String username,  String password,
			 String emailAddress,  String firstName,  String lastName,
			 String dateOfBirth, AmericanFootballSpringBootModelContactDetails contactdetails) {
		super();
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.contactdetails = contactdetails;
	}
	
	

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() { 
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AmericanFootballSpringBootModelContactDetails getContactdetails() {
		return contactdetails;
	}

	public void setContactdetails(AmericanFootballSpringBootModelContactDetails contactdetails) {
		this.contactdetails = contactdetails;
	}
	
}
	