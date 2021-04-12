package com.mahindra.epcfrm.exception;

import java.util.Date;

public class ErrorDetails {

	
	
	private Date timestamp;
	private String message;
	private String details;
	private Object Data;
	private Integer status;
	private boolean isSuccess;
	
	public ErrorDetails(Date timestamp, String message, String details, Object data, Integer status,
			boolean isSuccess) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		Data = data;
		this.status = status;
		this.isSuccess = isSuccess;
	}
	public ErrorDetails() {
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
    public void setDetails(String details) {
		this.details = details;
	}

	public Object getData() {
		return Data;
	}

	public void setData(Object data) {
		Data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
    
}
