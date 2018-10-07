package com.idea.spbmodeldemo.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/25
 * @描述：查询所有车辆品牌列表dto
 * @version：1.0
 */
@Data
@ApiModel(value = "根据条件查询所有车辆品牌信息",description = "分页查询所有车辆品牌列表 dto")
public class VehicleBrandQueryAllDTO implements Serializable {

    private static final long serialVersionUID = -5884536156642251996L;

    @ApiModelProperty(value = "车辆品牌表id")
    private Integer id;
    /**
     * 车牌名称
     */
    @ApiModelProperty(value = "品牌名称，支持模糊查询")
    private String name;

}
