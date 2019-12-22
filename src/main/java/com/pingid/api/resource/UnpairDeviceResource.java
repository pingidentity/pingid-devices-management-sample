package com.pingid.api.resource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pingid.api.JwtPayloadReq;
import com.pingid.api.JwtPayloadRes;
import com.pingid.api.RequestHeader;
import com.pingid.api.unpairdevice.UnpairDeviceRequest;
import com.pingid.api.unpairdevice.UnpairDeviceResponse;
import com.pingid.dm.config.Config;
import com.pingid.dm.config.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/unpairdevice")
public class UnpairDeviceResource extends ApiResource<UnpairDeviceResponse> {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void unpairDevice(
            @Context HttpServletRequest request,
            @Context HttpServletResponse response,
            @FormParam("deviceId") String deviceId) throws Exception {

        final Config config = Config.getInstance(request.getSession().getServletContext());

        final String userName = (String) request.getSession().getAttribute(Constants.SessionAttribute.USER_NAME);

        JwtPayloadReq<UnpairDeviceRequest> jwtPayloadReq = new JwtPayloadReq(
                new UnpairDeviceRequest(userName, Long.valueOf(deviceId)),
                RequestHeader.create(config));

        String jwtPayloadJson = jwtPayloadReq.toJson();

        UnpairDeviceResponse unpairDeviceResponse = sendPost("unpairdevice/do", jwtPayloadJson, config);

        if (unpairDeviceResponse.getErrorId() != 200) {

            request.setAttribute("authErrMsg", unpairDeviceResponse.getErrorMsg());
            request.getRequestDispatcher("/jsp/DevicesMgmt.jsp").forward(request, response);
            return;
        }

        request.setAttribute(Constants.RequestParameter.SENDER, Constants.Common.DEVICES_MGMT);
        new GetUserDetailsResource().getUserDetails(request, response, userName);
    }

    @Override
    protected UnpairDeviceResponse getJwtPayloadResponse(Gson jwtPayloadGsonRes, String payload) {

        JwtPayloadRes<UnpairDeviceResponse> jwtPayloadRes =
                jwtPayloadGsonRes.fromJson(payload, new TypeToken<JwtPayloadRes<UnpairDeviceResponse>>(){}.getType());

        return jwtPayloadRes.getResponseBody();
    }
}
