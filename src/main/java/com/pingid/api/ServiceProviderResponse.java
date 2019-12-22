package com.pingid.api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceProviderResponse {

	private String spAlias;
	private String spName;
	private Date bypassExpiration;
	private UserStatus status; 
    
	public ServiceProviderResponse(String spAlias, String spName, Date bypassExpiration, UserStatus status) {

		this.spAlias = spAlias;
		this.bypassExpiration = bypassExpiration;
		this.status = status;
		this.spName = spName;
	}

	public ServiceProviderResponse() {
		super();
	}
	public void setSpAlias(String spAlias) {
		this.spAlias = spAlias;
	}
	
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	public String getSpAlias() {
		return spAlias;
	}
	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	public Date getBypassExpiration() {
		return bypassExpiration;
	}
	public UserStatus getStatus() {
		return status;
	}
	@Deprecated
	public void setSpUserName(String username){
		
	}
	public void setBypassExpiration(Date bypassExpiration) {
		this.bypassExpiration = bypassExpiration;
	}
	
	@Override
	public String toString() {
        return String.format("ServiceProviderResponse [spAlias=%s, bypassExpiration=%s, status=%s]",
                spAlias, bypassExpiration == null ? "n/a" : new SimpleDateFormat().format(bypassExpiration), status);
	}
}
