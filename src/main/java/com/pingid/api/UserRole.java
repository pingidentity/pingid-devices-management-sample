package com.pingid.api;

import java.util.HashMap;
import java.util.Map;

public enum UserRole {
	
	ADMIN("admin"),
	REGULAR("regular"),
	API_USER("api_user"),
	SUPER_ADMIN("super_admin");

	private String name;
	
	UserRole(String name) {
		this.name = name;
	}
	 
	private static Map<String, UserRole> types = new HashMap<String, UserRole>();
	
	static {

		for(UserRole type : UserRole.values()){
			types.put(type.getName(), type);
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static UserRole get(String authType){
		return types.get(authType);
	}
}
