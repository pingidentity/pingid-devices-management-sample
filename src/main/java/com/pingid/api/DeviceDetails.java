package com.pingid.api;

public class DeviceDetails {

	private String type;
	private String osVersion;
	private String appVersion;
	private String enrollment;
	private String phoneNumber;
	private String countryCode;
    private int sentNotClaimedSms = -1; // for backwards compatibility
    private int sentClaimedSms = -1; // for backwards compatibility
	private int availableNotClaimedSms;
	private int availableClaimedSms;
    private boolean pushEnabled;
    private boolean hasWatch;
	private String email;
	private long deviceId;
    private String deviceUuid;
	private DeviceRole deviceRole; 
	private String nickname;
	private String deviceModel;
	private String displayID;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Deprecated
	public int getSentNotClaimedSms() {
		return sentNotClaimedSms;
	}

    @Deprecated
	public void setSentNotClaimedSms(int sentNotClaimedSms) {
	}

    @Deprecated
	public int getSentClaimedSms() {
		return sentClaimedSms;
	}

    @Deprecated
	public void setSentClaimedSms(int sentClaimedSms) {
	}

	public int getAvailableNotClaimedSms() {
        return availableNotClaimedSms;
    }

    public void setAvailableNotClaimedSms(int sentNotClaimedSms) {
        this.availableNotClaimedSms = sentNotClaimedSms;
    }

    public int getAvailableClaimedSms() {
        return availableClaimedSms;
    }

    public void setAvailableClaimedSms(int sentClaimedSms) {
        this.availableClaimedSms = sentClaimedSms;
    }

    public boolean getPushEnabled() {
        return pushEnabled;
    }

    public void setPushEnabled(boolean pushEnabled) {
        this.pushEnabled = pushEnabled;
    }

    public boolean hasWatch() {
        return hasWatch;
    }

    public void setHasWatch(boolean hasWatch) {
        this.hasWatch = hasWatch;
    }

    public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

    public String getDeviceUuid() {
        return deviceUuid;
    }

    public void setDeviceUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid;
    }

	public DeviceRole getDeviceRole() {
		return deviceRole;
	}

	public void setDeviceRole(DeviceRole deviceRole) {
		this.deviceRole = deviceRole;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDisplayID() {
		return displayID;
	}

	public void setDisplayID(String displayID) {
		this.displayID = displayID;
	}

	@Override
	public String toString()
	{
        return String.format("DeviceDetails [type=%s, osVersion=%s, appVersion=%s, enrollment=%s, phoneNumber=%s, countryCode=%s, email=%s, displayID=%s, availableNotClaimedSms=%s, availableClaimedSms=%s, pushEnabled=%s, hasWatch=%s]",
                             type, osVersion, appVersion, enrollment, phoneNumber, countryCode, email, displayID, availableNotClaimedSms, availableClaimedSms, String.valueOf(pushEnabled), String.valueOf(hasWatch));
	}
}
