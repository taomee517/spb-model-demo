package com.idea.spbmodeldemo.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @项目：fzk-app-monitor
 * @创建人：luotao
 * @创建时间： 2018/8/25
 * @描述：车辆品牌基本信息vo
 * @version：1.0
 */
@Data
@ApiModel(value = "车系基本信息vo",description = "车系基本信息 查询结果vo")
public class VehicleModelBaseVO implements Serializable {

    private static final long serialVersionUID = -6058970108962339176L;

    /**
     * 车型表id
     */
    @ApiModelProperty(value = "车辆车系表id")
    private Integer id;

    /**
     * 车型名称
     */
    @ApiModelProperty(value = "车系中文名称")
    private String name;
    
    /**
     * 车型油箱容量
     */
    @ApiModelProperty(value = "车型油箱容量")
    private Integer fuelTankCap;


}
