package com.pingid.dm.auth.method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAuthMethod {

    void register(String userName, HttpServletRequest request, HttpServletResponse response) throws Exception;

    void authenticate(String userName, String deviceId, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
