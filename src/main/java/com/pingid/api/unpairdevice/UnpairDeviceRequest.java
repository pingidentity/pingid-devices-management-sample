package com.pingid.api.unpairdevice;

public class UnpairDeviceRequest {

	private String userName;
	private Long deviceId;

	public UnpairDeviceRequest(String userName, Long deviceId) {
		this.userName = userName;
		this.deviceId = deviceId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
    public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
}
