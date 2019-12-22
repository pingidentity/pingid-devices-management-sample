package com.pingid.api.getuserdetails;

import com.pingid.api.BaseResponseBody;
import com.pingid.api.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class GetUserResponse extends BaseResponseBody {
	
	private UserDetails userDetails;
	private List<UserDetails> sameDeviceUsersDetails = new ArrayList<UserDetails>();

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public List<UserDetails> getSameDeviceUsersDetails() {
		return sameDeviceUsersDetails;
	}

	public void addSameDeviceUsersDetails(UserDetails sameDeviceUsersDetails) {
		this.sameDeviceUsersDetails.add(sameDeviceUsersDetails);
	}
}
