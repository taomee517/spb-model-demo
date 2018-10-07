package com.idea.spbmodeldemo.common;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ResponseModel<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BaseResult result;
	
	@ApiModelProperty(value="返回数据")
	private T entity;

	public BaseResult getResult() {
		return result;
	}

	public void setResult(BaseResult result) {
		this.result = result;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}


	
}
