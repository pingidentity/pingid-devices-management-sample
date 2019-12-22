package com.pingid.api;

public class JwtPayloadRes<T> {

	private T  responseBody;

	public T getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(T responseBody) {
		this.responseBody = responseBody;
	}
}
