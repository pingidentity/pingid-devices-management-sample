package com.pingid.api;

import com.google.gson.Gson;

public class JwtPayloadReq<T> {

    private T reqBody;

    private RequestHeader reqHeader;

    public JwtPayloadReq(T reqBody, RequestHeader reqHeader) {
        this.reqBody = reqBody;
        this.reqHeader = reqHeader;
    }

    public String toJson() {
        return new Gson().toJson(this, JwtPayloadReq.class);
    }
}
