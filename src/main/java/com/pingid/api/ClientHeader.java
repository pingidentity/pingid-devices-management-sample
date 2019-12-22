package com.pingid.api;

public class ClientHeader {
	
	protected String clientData;
	
	public String getClientData() {
		return clientData;
	}

	public void setClientData(String clientData) {
		this.clientData = clientData;
	}

	@Override
	public String toString() {
		return "ClientHeader [clientData=" + clientData + "]";
	}

}
