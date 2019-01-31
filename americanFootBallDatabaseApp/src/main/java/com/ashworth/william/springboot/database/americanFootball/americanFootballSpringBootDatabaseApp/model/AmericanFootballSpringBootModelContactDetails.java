package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "coach")
@EntityListeners(AuditingEntityListener.class)
@IdClass(AmericanFootballSpringBootModelContactDetailsKey.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class AmericanFootballSpringBootModelContactDetails
{
	@Id
	String postcode;
	
	@Id
	String houseName;
		
	@NotBlank
	@Column (name = "address_line1") private String addressLine1;
	
	@Column (name = "address_line2") private String addressLine2;
	
	@NotBlank
	@Column (name = "ciy") private String city;
	
	@NotBlank
	@Column (name = "county") private String county;
	
	@NotBlank
	@Column (name = "phone_number") private String phoneNumber;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "AmericanFootballSpringBootModelUser")
	@JoinColumn(name = "username", nullable = true)
	private List<AmericanFootballSpringBootModelUser> users;
	
	public AmericanFootballSpringBootModelContactDetails()
	{
		
	}
		
	public AmericanFootballSpringBootModelContactDetails(String postcode, String houseName, String addressLine1, String city, String county, String phoneNumber)
	{
		this.postcode = postcode;
		this.houseName = houseName;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.county = county;
		this.phoneNumber = phoneNumber;
	}
	
	public AmericanFootballSpringBootModelContactDetails(String postcode, String houseName, String addressLine1, String addressLine2, String city, String county, String phoneNumber)
	{
		this.postcode = postcode;
		this.houseName = houseName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.county = county;
		this.phoneNumber = phoneNumber;
	}

	public String getPostcode() 
	{
		return postcode;
	}

	public void setPostcode(String postcode) 
	{
		this.postcode = postcode;
	}

	public String getHouseName() 
	{
		return houseName;
	}

	public void setHouseName(String houseName)
	{
		this.houseName = houseName;
	}

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2()
	{
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) 
	{
		this.addressLine2 = addressLine2;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCounty() 
	{
		return county;
	}

	public void setCounty(String county) 
	{
		this.county = county;
	}

	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	
}