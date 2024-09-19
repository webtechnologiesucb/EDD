package com.ucb.developer;

import java.util.Date;

public class Country{
	private int countryId;
	private String country;
	private Date lastUpdate;
	
	public Country() {
		this.countryId = 0;
		this.country = "";
		this.lastUpdate = new Date();
	}
	
	public int getCountryId() {
		return countryId;
	}
	
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Date getLastUpdate() {
		return lastUpdate;
	}
	
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	@Override
	public String toString() {
		return String.format("Country [ID=%d, Country=%s, Last Update=%s]", 
				countryId, country, lastUpdate.toString());
	}
}
