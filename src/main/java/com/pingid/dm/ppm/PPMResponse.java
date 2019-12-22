package com.pingid.dm.ppm;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PPMResponse {

	private String iss;
	private String sub;
	private String aud;
	private String nonce;
	private long exp;
	private long iat;
	private String jti;
	private String status;
	private String idpAccountId;
	private String authnContext;
	private String inResponseTo;
	private Integer assuranceLevel;
	private List<PPMAttribute> attributes;
	private String errorCode;
	private String message;
	private String dst;

	public PPMResponse() {
		this.attributes = null;
	}

	public String getIss() {
		return this.iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public String getSub() {
		return this.sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getAud() {
		return this.aud;
	}

	public void setAud(String aud) {
		this.aud = aud;
	}

	public String getNonce() {
		return this.nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public long getExp() {
		return this.exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	public void setExp(Date exp2) {
		this.exp = (exp2.getTime() / 1000L);
	}

	public long getIat() {
		return this.iat;
	}

	public void setIat(long iat) {
		this.iat = iat;
	}

	public void setIat(Date iatDate) {
		this.iat = (iatDate.getTime() / 1000L);
	}

	public String getJti() {
		return this.jti;
	}

	public void setJti(String jti) {
		this.jti = jti;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIdpAccountId() {
		return this.idpAccountId;
	}

	public void setIdpAccountId(String idpAccountId) {
		this.idpAccountId = idpAccountId;
	}

	public String getAuthncontext() {
		return this.authnContext;
	}

	public void setAuthncontext(String authncontext) {
		this.authnContext = authncontext;
	}

	public Integer getAssuranceLevel() {
		return this.assuranceLevel;
	}

	public void setAssuranceLevel(Integer assurancelevel) {
		this.assuranceLevel = assurancelevel;
	}

	public List<PPMAttribute> getAttributes() {
		return this.attributes;
	}

	public void setAttributes(List<PPMAttribute> attributes) {
		this.attributes = attributes;
	}

	public void addAttribute(PPMAttribute attribute) {
		if (this.attributes == null) {
			this.attributes = new ArrayList();
		}
		this.attributes.add(attribute);
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthnContext() {
		return this.authnContext;
	}

	public void setAuthnContext(String authnContext) {
		this.authnContext = authnContext;
	}

	public String getInResponseTo() {
		return this.inResponseTo;
	}

	public void setInResponseTo(String inResponseTo) {
		this.inResponseTo = inResponseTo;
	}

	public String getDst() {
		return this.dst;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}

	public String toJson() {
		String json = new Gson().toJson(this);
		return json;
	}

	public static PPMResponse fromJson(String json) {

		if (json == null || json.isEmpty()) {
			return null;
		}
		Gson gson = new Gson();
		PPMResponse response = (PPMResponse) gson.fromJson(json, PPMResponse.class);
		return response;
	}

	@Override
	public String toString() {
		return "PPMResponse{" +
				"iss='" + iss + '\'' +
				", sub='" + sub + '\'' +
				", aud='" + aud + '\'' +
				", nonce='" + nonce + '\'' +
				", exp=" + exp +
				", iat=" + iat +
				", jti='" + jti + '\'' +
				", status='" + status + '\'' +
				", idpAccountId='" + idpAccountId + '\'' +
				", authnContext='" + authnContext + '\'' +
				", inResponseTo='" + inResponseTo + '\'' +
				", assuranceLevel=" + assuranceLevel +
				", attributes=" + attributes +
				", errorCode='" + errorCode + '\'' +
				", message='" + message + '\'' +
				", dst='" + dst + '\'' +
				'}';
	}
}
