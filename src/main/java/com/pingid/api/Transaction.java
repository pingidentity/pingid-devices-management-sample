package com.pingid.api;

import java.util.Date;

public class Transaction {

	private String type;
	private Date date;
	private String Details;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	
	@Override
	public String toString()
	{
	    return String.format("Transaction [type=%s, date=%s, details=%s]", type, date, Details);
    }
}
