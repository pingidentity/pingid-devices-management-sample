<%@ page import="com.pingid.dm.config.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form id="redirectForm" action=<%= request.getAttribute(Constants.RequestParameter.DEST_URL) %>  method="post">

    <input name="idp_account_id" type="hidden" id="idpAccountId"
           value=<%= request.getAttribute(Constants.RequestParameter.ORG_UUID) %> />

    <input name="ppm_request" type="hidden" id="ppm_request"
           value=<%= request.getAttribute(Constants.RequestParameter.PPM_REQUEST) %> />

    <input name="iss" type="hidden" id="iss" value=<%= request.getAttribute(Constants.Common.ISS) %> />

</form>

