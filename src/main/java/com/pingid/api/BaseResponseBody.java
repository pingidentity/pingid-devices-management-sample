package com.pingid.api;

public class BaseResponseBody extends ClientHeader {

	private Integer errorId;
	private String errorMsg;
	private String UniqueMsgID;

	public Integer getErrorId() {
		return errorId;
	}
	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getUniqueMsgId() {
		return UniqueMsgID;
	}

	public void setUniqueMsgId(String uniqueMsgId) {
		UniqueMsgID = uniqueMsgId;
	}
	
	@Override
	public String toString() {
		return String.format("errorId=%d, errorMsg=%s, UniqueMsgID=%s", errorId, errorMsg, UniqueMsgID);
	}
}