package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

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
	@Id
	@Column (name = "username") private String username;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="coach_username", nullable=true)
	private AmericanFootballSpringBootModelCoach coach;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="player_username", nullable=true)
	private AmericanFootballSpringBootModelPlayer player;
	
	@NotBlank
	@Column (name = "password") private String password;
	
	@NotBlank
	@Column (name = "email_address") private String email_address;
	
	@NotBlank
	@Column (name = "first_name") private String first_name;
	
	@NotBlank
	@Column (name = "last_name") private String last_name;
	
	@NotBlank
	@Column (name = "age") private int age;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private AmericanFootballSpringBootModelContactDetails contactDetails;
	

	public AmericanFootballSpringBootModelUser()
	{
		
	}
		
	public AmericanFootballSpringBootModelUser(String username, String password, String email_address, String first_name, String last_name, int age, String actors)
	{
		this.username = username;
		this.password = password;
		this.email_address = email_address;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getEmail_address()
	{
		return email_address;
	}

	public void setEmail_address(String email_address)
	{
		this.email_address = email_address;
	}

	public String getFirst_name() 
	{
		return first_name;
	}

	public void setFirst_name(String first_name)
	{
		this.first_name = first_name;
	}

	public String getLast_name() 
	{
		return last_name;
	}

	public void setLast_name(String last_name)
	{
		this.last_name = last_name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	
}