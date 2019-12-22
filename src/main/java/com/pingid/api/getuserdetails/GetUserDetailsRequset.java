package com.pingid.api.getuserdetails;

public class GetUserDetailsRequset {

    private String userName;
    private boolean getSameDeviceUsers;

    public GetUserDetailsRequset(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isGetSameDeviceUsers() {
        return getSameDeviceUsers;
    }

    public void setGetSameDeviceUsers(boolean getSameDeviceUsers) {
        this.getSameDeviceUsers = getSameDeviceUsers;
    }
}
