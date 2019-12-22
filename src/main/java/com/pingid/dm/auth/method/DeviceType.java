package com.pingid.dm.auth.method;

import com.pingid.api.DeviceDetails;
import com.pingid.dm.ppm.cache.DevicesMgmtCache;

public enum DeviceType {

    HybridWebAuthnSecurityKey("Security Key", new HybridWebAuthnSecurityKey()),
    HybridWebAuthnPlatform("FIDO2 Biometrics", new HybridWebAuthnPlatform());

    private String name;
    private IAuthMethod iAuthMethod;

    DeviceType(String name, IAuthMethod iAuthMethod) {
        this.name = name;
        this.iAuthMethod = iAuthMethod;
    }

    public String getName() {
        return name;
    }

    public IAuthMethod getiAuthMethod() {
        return iAuthMethod;
    }

    public static DeviceType getDeviceType(String userName, String deviceId) {

        if (!isValidDeviceId(deviceId)){
            return null;
        }

        DeviceDetails deviceDetails = DevicesMgmtCache.User2DevicesDetailsCache.get(userName)
                .stream()
                .filter(d -> d.getDeviceId() == Long.valueOf(deviceId))
                .findAny()
                .orElse(null);

        for (DeviceType deviceType: DeviceType.values()) {
            if (deviceDetails.getType().equals(deviceType.getName())) {
                return deviceType;
            }
        }

        return null;
    }

    private static boolean isValidDeviceId(final String deviceId) {

        if (deviceId == null || deviceId.isEmpty()) {
            return false;
        }

        try {

            Long.parseLong(deviceId);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
