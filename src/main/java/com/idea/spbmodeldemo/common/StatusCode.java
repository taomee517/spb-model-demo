package com.idea.spbmodeldemo.common;


import org.springframework.util.StringUtils;

public enum StatusCode {
	/**
	 * 参数错误
	 */
	S_PARAM_ERROR("401","参数错误"),
	
	S_NO_USER("302","该用户不存在"),
	
	S_VALIDATE_FAIL("6","数据异常"),
	
	S_SIGN_FAIL("5","无效请求"),
	
	S_AUTH_FAIL("4","认证失败"),
	
	S_PERMISSION("3","超时"),
	
	S_EXCEPTION("2","服务器异常"),
	
	S_SUCCESS("0","执行成功"),
	
	S_PER_TERMINAL("7","无设备操作权限");
	
	private String code;
	
	private String desc;
	
	private StatusCode(String code,String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	//通过code获取 枚举类型
	public static StatusCode  getEumBycode(String resultCode) {
		if(StringUtils.isEmpty(resultCode)) {
			return null;
		}
		for(StatusCode _enum:StatusCode.values()) {
			if(resultCode==_enum.getCode()) {
				return _enum;
			}
		}
		return null;
	}
	
	

}
