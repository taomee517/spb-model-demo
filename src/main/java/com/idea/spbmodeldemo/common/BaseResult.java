package com.idea.spbmodeldemo.common;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class BaseResult implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="返回状态码",dataType="String")
	private String resultCode;
	
	@ApiModelProperty(value="返回消息",dataType="String")
	private String resultMessage;
	public BaseResult() {

	}
	
	public BaseResult(StatusCode statusCode) {
		this.resultCode = statusCode.getCode();
		this.resultMessage = statusCode.getDesc();
	}
	
	public BaseResult(StatusCode statusCode,String msg) {
		this.resultCode = statusCode.getCode();
		this.resultMessage = msg;
	}
	
	public void setStatusCode(StatusCode statusCode) {
		this.resultCode = statusCode.getCode();
		this.resultMessage = statusCode.getDesc();
	}
	
	public void setStatusCode(StatusCode statusCode,String msg) {
		this.resultCode = statusCode.getCode();
		this.resultMessage = msg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	
	

}
