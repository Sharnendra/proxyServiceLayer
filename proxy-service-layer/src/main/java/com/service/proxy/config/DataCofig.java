package com.service.proxy.config;

public class DataCofig {

	@Override
	public String toString() {
		return "DataCofig [servicename=" + servicename + ", host=" + host + ", json=" + json + "]";
	}

	private String servicename;
	private String host;
	private String json;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	

}
