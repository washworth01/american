package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AmericanFootballSpringBootModelContactDetailsKey implements Serializable
{
	
	private String postcode;
	
	private Integer houseNumber;

	public AmericanFootballSpringBootModelContactDetailsKey (String postcode, Integer houseNumber)
	{
		this.postcode = postcode;
		this.houseNumber = houseNumber;
	}
	
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
		
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof AmericanFootballSpringBootModelContactDetailsKey)) return false;
	        AmericanFootballSpringBootModelContactDetailsKey that = (AmericanFootballSpringBootModelContactDetailsKey) o;
	        return Objects.equals(getPostcode(), that.getPostcode()) &&
	                Objects.equals(getHouseNumber(), that.getHouseNumber());
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(getPostcode(), getHouseNumber());
	    }
}
