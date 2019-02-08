package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class AmericanFootballSpringBootModelContactDetailsKey implements Serializable
{
	
	private String postcode;
	private int houseNumber;

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
