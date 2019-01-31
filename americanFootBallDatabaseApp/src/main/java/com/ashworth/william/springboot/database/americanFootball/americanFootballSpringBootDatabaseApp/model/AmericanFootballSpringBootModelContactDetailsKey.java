package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AmericanFootballSpringBootModelContactDetailsKey
{
	@Column (name = "postcode", nullable = false) private String postcode;
	
	@Column (name = "house_number", nullable = false) private int houseNumber;

	public String getPostcode() 
	{
		return postcode;
	}

	public void setPostcode(String postcode) 
	{
		this.postcode = postcode;
	}

	public int getHouseNumber() 
	{
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) 
	{
		this.houseNumber = houseNumber;
	}
		
}
