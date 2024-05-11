package com.CMSBackend.CMS.dto;

public class ResultDto {

	public Object result;
	public int status;
	public String message;

	public Object getAlternativeResult() {
		return alternativeResult;
	}

	public void setAlternativeResult(Object alternativeResult) {
		this.alternativeResult = alternativeResult;
	}

	public Object alternativeResult;
	
	public ResultDto(Object result,int status,String message) {
		this.result = result;
		this.status = status;
		this.message = message;
	}
	
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
