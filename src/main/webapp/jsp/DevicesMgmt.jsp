<%@ page import="com.pingid.api.DeviceDetails" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/js/devices-mgmt.js" type="text/javascript"></script>

    <style>

        table {border-spacing: 20px 5px; border-collapse:collapse;}
        table tr.device_name {outline: thin solid; padding: 5px; cursor: pointer;}
        table tr td {padding: 8px; font-size: 16px;}

        .selected {
            background-color: aliceblue;
            color: black;
        }

    </style>

</head>

<body>

    <h2>PingID Devices Management Demo</h2>

    <p>Welcome <%=request.getAttribute("userName")%></p><%
        List<DeviceDetails> devices = new ArrayList<DeviceDetails>();

        if (request.getAttribute("devices") != null) {
            devices = (List<DeviceDetails>) request.getAttribute("devices");
        }

        if (!devices.isEmpty()) {

            String deviceId = (String) request.getAttribute("deviceId");
        %>
        <div>
            <h3>Devices:</h3>

            <table id="table">
                <tr>
                    <th align="center">Name</th>
                    <th align="center">Type</td>
                </tr>
                <%
                    for (DeviceDetails device: devices) {
                %>
                    <tr class="device_name" data-value="<%=device.getDeviceId()%>">
                        <td><%=device.getNickname()%></td>
                        <td><%=device.getType()%></td>
                        <% if ( deviceId != null && device.getDeviceId() == (Long.valueOf(deviceId)) &&
                            "success".equalsIgnoreCase( (String) request.getAttribute("authResult")) ){
                        %>
                            <td id="status">&#9989;</td>
                        <%
                        }
                        else { %>
                            <td id="status"></td>
                        <%}%>
                    </tr>
                <%  }%>
            <table/>

            <p id="authMsg"></p>

            <form id="auth_form" action="<%=request.getContextPath()%>/pingid/auth/start" >
                <input type="submit" id="authenticate" value="Authenticate" style="margin-left: 10px;"/>
            </form>
            <form method="post" id="unpair_form" action="<%=request.getContextPath()%>/pingid/unpairdevice" >
                <input type="hidden" id="deviceId" name="deviceId" />
                <input type="submit" id="unpair" value="Remove Device" style="margin-left: 20px;"/>
            </form>

            <div id="authErrMsg" style="color:red;">
                <p><%= request.getAttribute("authErrMsg") != null ? request.getAttribute("authErrMsg") : "" %></p>
            </div>
        </div>

        <br><%}%>

    <div>
        <p>Select a device type to register a new device.</p>
        <form id="reg_form" action="<%=request.getContextPath()%>/pingid/register/start" >
            <label for="deviceType">Device Type:</label>
            <select id="deviceType" name="deviceType" required>
                <option value="HybridWebAuthnSecurityKey">FIDO Security Key</option>
                <option value="HybridWebAuthnPlatform">FIDO biometric device</option>
            </select>
            <input id="addDevice" type="submit" value="Add Device"/>
        </form>
    </div>

    <div id="redirect" style="display: none;"></div>

    <div id="regErrMsg" style="color:red;">
        <p><%= request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "" %></p>
    </div>

</body>
</html>
