package com.example.alpha.pojo;

public class AppResponseMessage<T> {

	private Integer httpsStatusCode;
	private String responseMessage;
	private T response;
	
	public AppResponseMessage() {
	}

	public AppResponseMessage(Integer httpsStatusCode, String responseMessage, T response) {
		super();
		this.httpsStatusCode = httpsStatusCode;
		this.responseMessage = responseMessage;
		this.response = response;
	}

	public Integer getHttpsStatusCode() {
		return httpsStatusCode;
	}

	public void setHttpsStatusCode(Integer httpsStatusCode) {
		this.httpsStatusCode = httpsStatusCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}
	
	
}
