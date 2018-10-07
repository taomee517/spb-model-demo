package com.idea.spbmodeldemo.common;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页dto 
 * @author hunter
 *
 */
@ApiModel(value="分页实体")
public class PageDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6971205939992726302L;

	@ApiModelProperty(value="单页查询条数",notes="默认条数10条")
	private int pageSize = 10;
	
	@ApiModelProperty(value="当前页码",notes="从1开始,默认页码从1开始")
	private int pageNum = 1;
	
	@ApiModelProperty(value="是否分页",notes="是否分页,默认为false")
	private boolean page = false;
	
	public int getOffset() {
		return (pageNum-1)<0?0:(pageNum-1)*pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public boolean isPage() {
		return page;
	}

	public void setPage(boolean page) {
		this.page = page;
	}
	
	

}
