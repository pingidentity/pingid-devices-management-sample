package com.pingid.dm.ppm;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class PPMRequest {

	private String iss;
	private String sub;
	private String aud;
	private String nonce;
	private long exp;
	private long iat;
	private String jti;
	private String idpAccountId;
	private String idpEntityId;
	private List<PPMAttribute> attributes;
	private String returnUrl;
	private String dst;

	public PPMRequest() {
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

	public String getNonce() {
		return this.nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public void setAud(String aud) {
		this.aud = aud;
	}

	public long getExp() {
		return this.exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	public long getIat() {
		return this.iat;
	}

	public void setIat(long iat) {
		this.iat = iat;
	}

	public String getJti() {
		return this.jti;
	}

	public void setJti(String jti) {
		this.jti = jti;
	}

	public String getIdpEntityId() {
		return this.idpEntityId;
	}

	public void setIdpEntityId(String idpEntityId) {
		this.idpEntityId = idpEntityId;
	}

	public String getIdpAccountId() {
		return this.idpAccountId;
	}

	public void setIdpAccountId(String idpAccountId) {
		this.idpAccountId = idpAccountId;
	}

	public List<PPMAttribute> getAttributes() {
		return this.attributes;
	}

	public void setAttributes(List<PPMAttribute> attributes) {
		this.attributes = attributes;
	}

	public void addAttribute(PPMAttribute attribute) {
		if (this.attributes == null) {
			this.attributes = new ArrayList<PPMAttribute>();
		}
		this.attributes.add(attribute);
	}

	public String getReturnUrl() {
		return this.returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
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

	public static PPMRequest fromJson(String json) {

		if (json == null || json.isEmpty()) {
			return null;
		}

		Gson gson = new Gson();
		PPMRequest request = (PPMRequest) gson.fromJson(json, PPMRequest.class);
		return request;
	}
}