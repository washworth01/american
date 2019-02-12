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
public class AmericanFootballSpringBootModelUser
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long userid;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String emailAddress;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth; 
	
	@NotNull
	private String description;
		
	@ManyToOne(fetch = FetchType.EAGER, optional =false)
	@JoinColumn(name = "contactdetailsid", nullable = false)
	private AmericanFootballSpringBootModelContactDetails contactdetails;
			
	public AmericanFootballSpringBootModelUser()
	{
		
	}

	public AmericanFootballSpringBootModelUser(@NotBlank String username, @NotBlank String password,
			@NotBlank String emailAddress, @NotBlank String firstName, @NotBlank String lastName,
			@NotBlank Date dateOfBirth, @NotBlank String description, @NotBlank AmericanFootballSpringBootModelContactDetails contactdetails,
			AmericanFootballSpringBootModelCoach coach) {
		super();
		this.contactdetails = contactdetails;
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.description = description;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
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
	