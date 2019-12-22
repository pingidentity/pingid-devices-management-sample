package com.pingid.api.resource;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pingid.api.DeviceDetails;
import com.pingid.api.JwtPayloadReq;
import com.pingid.api.JwtPayloadRes;
import com.pingid.api.RequestHeader;
import com.pingid.api.getuserdetails.GetUserDetailsRequset;
import com.pingid.api.getuserdetails.GetUserResponse;
import com.pingid.dm.auth.method.DeviceType;
import com.pingid.dm.auth.method.HybridWebAuthnPlatform;
import com.pingid.dm.config.Config;
import com.pingid.dm.config.Constants;
import com.pingid.dm.ppm.cache.DevicesMgmtCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@Path("/getuserdetails")
public class GetUserDetailsResource extends ApiResource<GetUserResponse> {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void getUserDetails(
            @Context HttpServletRequest request,
            @Context HttpServletResponse response,
            @FormParam("userName") String userName) throws Exception {

        final Config config = Config.getInstance(request.getSession().getServletContext());

        List<DeviceDetails> userDevices;

        if (request.getAttribute("errorMsg") != null) {
            userDevices = DevicesMgmtCache.User2DevicesDetailsCache.get(userName);
        }
        else {

            JwtPayloadReq<GetUserDetailsRequset> jwtPayloadReq = new JwtPayloadReq(
                    new GetUserDetailsRequset(userName),
                    RequestHeader.create(config));

            String jwtPayloadJson = jwtPayloadReq.toJson();

            GetUserResponse userResponse = sendPost("getuserdetails/do", jwtPayloadJson, config);

            if (userResponse.getErrorId() != 200) {

                request.setAttribute("errorMsg", userResponse.getErrorMsg());
                final String resource;
                if (Constants.Common.DEVICES_MGMT.equals(request.getAttribute(Constants.RequestParameter.SENDER))) {
                    resource = "/jsp/DevicesMgmt.jsp";
                }
                else {
                    resource = "/index.jsp";
                }

                request.getRequestDispatcher(resource).forward(request, response);
                return;
            }

            DevicesMgmtCache.User2DevicesDetailsCache.put(userName, userResponse.getUserDetails().getDevicesDetails());
            userDevices = userResponse.getUserDetails().getDevicesDetails();
        }

        if (request.getSession().getAttribute(Constants.SessionAttribute.USER_NAME) == null) {
            request.getSession().setAttribute(Constants.SessionAttribute.USER_NAME, userName);
        }
        request.setAttribute("userName", userName);
        request.setAttribute("devices", filter(userDevices));
        request.getRequestDispatcher("/jsp/DevicesMgmt.jsp").forward(request, response);
    }

    @Override
    protected GetUserResponse getJwtPayloadResponse(Gson jwtPayloadGsonRes, String payload) {

        JwtPayloadRes<GetUserResponse> jwtPayloadRes =
                jwtPayloadGsonRes.fromJson(payload, new TypeToken<JwtPayloadRes<GetUserResponse>>(){}.getType());

        return jwtPayloadRes.getResponseBody();
    }

    private List<DeviceDetails> filter(List<DeviceDetails> deviceDetails) {

        List<String> deviceTypes = EnumSet.allOf(DeviceType.class)
                .stream()
                .map(deviceType -> deviceType.getName()).collect(Collectors.toList());

        return deviceDetails.stream().
                filter(device -> deviceTypes.contains(device.getType())).collect(Collectors.toList());
    }
}
