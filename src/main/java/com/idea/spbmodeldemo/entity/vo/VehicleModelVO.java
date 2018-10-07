package com.idea.spbmodeldemo.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/27
 * @描述：车型 信息vo
 * @version：1.0
 */
@Data
@ApiModel(value = "车型信息",description = "查询 车型信息 接口返回数据")
public class VehicleModelVO implements Serializable {

    private static final long serialVersionUID = 6340164518734914818L;

    /**
     * 车型表id
     */
    @ApiModelProperty(value = "车型表id")
    private Integer id;

    @ApiModelProperty(value = "车型名称")
    private String name;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;
    /**
     * 车型对应的车辆品牌id
     */
    @ApiModelProperty(value = "车系名称")
    private String seriesName;
    
    @ApiModelProperty(value = "能源类型")
    private String energyType;
    
    @ApiModelProperty(value = "油箱容量")
    private Integer fuelTankCap;
    
    @ApiModelProperty(value = "车辆数量")
    private Integer vehicleNum;


}
