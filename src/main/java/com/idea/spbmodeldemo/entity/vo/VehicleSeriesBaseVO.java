package com.idea.spbmodeldemo.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/28
 * @描述：查询 所有车系基础信息
 * @version：1.0
 */
@Data
@ApiModel(value = "获取所有车系 基础数据vo",description = "用于下拉列表展示 所有车系数据vo")
public class VehicleSeriesBaseVO implements Serializable {

    private static final long serialVersionUID = -3434094953226118984L;

    /**
     * 车系表id
     */
    @ApiModelProperty(value = "车系表id")
    private Integer id;

    /**
     * 车系名称
     */
    @ApiModelProperty(value = "车系名称")
    private String name;
}
