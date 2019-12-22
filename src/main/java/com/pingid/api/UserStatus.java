package com.pingid.api;

public enum UserStatus {

	ACTIVE("active"),
	PENDING("pending"),
	NOT_ACTIVE("not_active"),
	PENDING_ACTIVATION("pending_activation"),
	SUSPENDED("suspended"),
	PENDING_CHANGE_DEVICE("pending_change_device"),
	LOCKED("locked"),
	OTP_LOCKED("otp_locked"),
	BYPASS("bypass");

	private String name;

	UserStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public static UserStatus get(String role) {
		for (UserStatus status : UserStatus.values()) {
			if (status.getName().equals(role.trim())) {
				return status;
			}
		}
		return UserStatus.NOT_ACTIVE;
	}
}