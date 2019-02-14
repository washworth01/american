package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "contact_details")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class AmericanFootballSpringBootModelContactDetails
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long contactdetailsid;
	
	private Integer houseNumber;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String city;
	
	private String county;
	
	private String postcode;
	
	private String phoneNumber;

	public AmericanFootballSpringBootModelContactDetails()
	{
		
	}
 
	public AmericanFootballSpringBootModelContactDetails( String postcode, Integer houseNumber,
			 String addressLine1, String city, String county,
			 String phoneNumber) {
		super();
		this.houseNumber = houseNumber;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.county = county;
		this.postcode = postcode;
		this.phoneNumber = phoneNumber;
	}

	public AmericanFootballSpringBootModelContactDetails( String postcode, Integer houseNumber,
			 String addressLine1, String addressLine2,  String city, String county,
			 String phoneNumber) {
		super();
		this.postcode = postcode;
		this.houseNumber = houseNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.county = county; 
		this.phoneNumber = phoneNumber;
	}

	public Long getContactDetailsId() {
		return contactdetailsid;
	}

	public void setContactDetailsId(Long contactDetailsId) {
		this.contactdetailsid = contactDetailsId;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
		

	
}