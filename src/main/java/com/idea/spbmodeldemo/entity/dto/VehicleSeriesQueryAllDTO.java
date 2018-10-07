package com.idea.spbmodeldemo.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/28
 * @描述：车系 查询dto
 * @version：1.0
 */
@Data
@ApiModel(value = "查询车系所有数据 dto",description = "查询车系所有数据 接口dto")
public class VehicleSeriesQueryAllDTO implements Serializable {

    private static final long serialVersionUID = 6295591814860245321L;

    @ApiModelProperty(value = "车系表id")
    private Integer id;

    @ApiModelProperty(value = "车辆的品牌id")
    private Integer brandId;

    @ApiModelProperty(value = "车辆车系的名称，用于精确查找")
    private String name;

    @ApiModelProperty(value = "输入 车系名称 进行模糊查询")
    private String keyWord;
}
