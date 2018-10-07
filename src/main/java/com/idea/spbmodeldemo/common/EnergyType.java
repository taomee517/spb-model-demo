package com.idea.spbmodeldemo.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 输出类型枚举类
 * @author luotao
 *
 */

public enum EnergyType {
	T_FUEL(1, "燃油"), 
	T_ELECTRIC(2, "电动"), 
	T_MIX(3, "混动"),
//	T_GASOLINE(4, "汽油")
	;
	
	

	private Integer code;
	private String type;

	private EnergyType(Integer code, String type) {
		this.code = code;
		this.type = type;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public final static Map<Integer, String> map = new HashMap<>();
	static {
		for (EnergyType t : values()) {
			map.put(t.getCode(), t.getType());
		}
	}

	/**
	 * 根据id获取实例
	 * 
	 * @param id
	 * @return
	 */
	public static String getTypeByCode(int id) {
		return map.get(id);
	}
	

}