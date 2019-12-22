package com.pingid.api;

import java.util.Date;
import java.util.List;

public class UserDetails {

	private String fname;
	private String lname; 
	private UserStatus status; 
	private boolean isUserInBypass;
	private boolean isUserEnabled;
	private String email; 
	private String userName; 
	private String picURL; 
	private UserRole role;
	private Date lastLogin; 
	private Date bypassExpiration;
	private long   userId; // leave for BC
    //private String userUuid;
	private DeviceDetails deviceDetails;
	private List<DeviceDetails> devicesDetails;
	private List<Transaction> lastTransactions;
	private List<ServiceProviderResponse> spList;

	public UserDetails(){
		super();
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicURL() {
		return picURL;
	}

	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

    public List<ServiceProviderResponse> getSpList() {
		return spList;
	}

	public void setSpList(List<ServiceProviderResponse> spList) {
		this.spList = spList;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getBypassExpiration() {
		return bypassExpiration;
	}

	public void setBypassExpiration(Date bypassUntil) {
		this.bypassExpiration = bypassUntil;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public DeviceDetails getDeviceDetails() {
		return deviceDetails;
	}

	public void setDeviceDetails(DeviceDetails deviceDetials) {
		this.deviceDetails = deviceDetials;
	}

	public List<Transaction> getLastTransactions() {
		return lastTransactions;
	}

	public void setLastTransactions(List<Transaction> lastTransactions) {
		this.lastTransactions = lastTransactions;
	}

	public boolean isUserInBypass() {
		return isUserInBypass;
	}

	public boolean isUserEnabled() {
		return isUserEnabled;
	}

	public void setUserEnabled(boolean isUserEnabled) {
		this.isUserEnabled = isUserEnabled;
	}

	public void setUserInBypass(boolean isUserInBypass) {
		this.isUserInBypass = isUserInBypass;
	}

	public List<DeviceDetails> getDevicesDetails() {
		return devicesDetails;
	}

	public void setDevicesDetails(List<DeviceDetails> devicesDetails) {
		this.devicesDetails = devicesDetails;
	}

	@Override
	public String toString() {
		return "UserDetails [fname=" + fname + ", lname=" + lname + ", status="
				+ status + ", isUserInBypass=" + isUserInBypass
				+ ", isUserEnabled=" + isUserEnabled + ", email=" + email
				+ ", userName=" + userName + ", picURL=" + picURL + ", role="
				+ role + ", lastLogin=" + lastLogin + ", bypassExpiration="
				+ bypassExpiration + ", deviceDetails="
				+ deviceDetails + ", lastTransactions=" + lastTransactions
				+ ", spList=" + spList + "]";
	}
}
