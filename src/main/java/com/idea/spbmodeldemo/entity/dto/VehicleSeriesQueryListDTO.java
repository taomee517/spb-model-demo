package com.idea.spbmodeldemo.entity.dto;


import com.idea.spbmodeldemo.common.PageDTO;
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
@ApiModel(value = "分页查询车系 dto",description = "分页车系查询 接口dto")
public class VehicleSeriesQueryListDTO extends PageDTO {

    private static final long serialVersionUID = 6295591814860245321L;

    @ApiModelProperty(value = "车辆的品牌id")
    private Integer brandId;

    @ApiModelProperty(value = "输入 车系名称 进行模糊查询")
    private String keyword;
}
