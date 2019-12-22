package com.pingid.dm;

import com.pingid.dm.auth.method.DeviceType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public enum DevicesMgmtMgr {

    INSTANCE;

    public void register(
            String userName,
            DeviceType deviceType,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        if (deviceType != null) {
            deviceType.getiAuthMethod().register(userName, request, response);
        }
    }

    public void authenticate(
            String userName,
            String deviceId,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        DeviceType deviceType = DeviceType.getDeviceType(userName, deviceId);
        if (deviceType != null) {
            deviceType.getiAuthMethod().authenticate(userName, deviceId, request, response);
        }
    }
}
