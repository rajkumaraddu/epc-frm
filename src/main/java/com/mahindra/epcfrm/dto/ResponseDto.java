package com.mahindra.epcfrm.dto;


public class ResponseDto {
	private Object Data;
	private Integer status;
	private String message;
	private boolean isSuccess;
	
	public Object getData() {
		return Data;
	}
	public void setData(Object data) {
		Data = data;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer ok) {
		this.status = ok;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
}
