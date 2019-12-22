package com.pingid.api.unpairdevice;

import com.pingid.api.BaseResponseBody;

public class UnpairDeviceResponse extends BaseResponseBody {

	public UnpairDeviceResponse(){
		super();
	}

	@Override
	public String toString() {
		return "UnpairDeviceResponse [ErrorId=" + getErrorId()
				+ ", ErrorMsg=" +  "\"" + getErrorMsg() + "\"" + ", UniqueMsgId="
				+ getUniqueMsgId() + ", ClientData=" + getClientData()
				+ "]";
	}
}
