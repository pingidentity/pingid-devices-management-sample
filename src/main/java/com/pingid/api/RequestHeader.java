package com.pingid.api;

import com.pingid.dm.config.Config;
import com.pingid.dm.config.Constants;

public class RequestHeader {

	private String orgAlias;
	private String version;
	private String apiUserId;
	private String secretKey;
	private String sessionId;
	private String timestamp;
	private String locale;
	private String clientVersion;
	
	public String getOrgAlias() {
		return orgAlias;
	}
	public String getVersion() {
		return version;
	}
	public String getApiUserId() {
		return apiUserId;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public String getSessionId() {
		return sessionId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setOrgAlias(String orgAlias) {
		this.orgAlias = orgAlias;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setApiUserId(String apiUserId) {
		this.apiUserId = apiUserId;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
    public String getLocale() {
        return locale;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }
    public String getClientVersion() {
        return clientVersion;
    }
    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public static RequestHeader create(Config config) {

		RequestHeader requestHeader = new RequestHeader();
		requestHeader.setLocale(Constants.RequestParameter.LOCALE);
		requestHeader.setSecretKey(config.getProperty(Constants.PropFileParam.ORG_TOKEN));
		requestHeader.setOrgAlias(config.getProperty(Constants.PropFileParam.ORG_ALIAS));
		requestHeader.setVersion(Constants.RequestParameter.API_VERSION);

		return requestHeader;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{");
		sb.append("orgAlias='").append(orgAlias).append('\'');
		sb.append(", token='").append(secretKey).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
