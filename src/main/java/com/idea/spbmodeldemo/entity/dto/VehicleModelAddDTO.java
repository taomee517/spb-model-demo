package com.idea.spbmodeldemo.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/27
 * @描述：车型 添加dto
 * @version：1.0
 */
@Data
@ApiModel(value = "添加 车型 信息",description = "添加 车型 接口 dto")
public class VehicleModelAddDTO implements Serializable {

    private static final long serialVersionUID = 6277793026154764957L;

    @ApiModelProperty(value = "车型id,车型编辑时不能为空",required = true)
    private Integer id;
    
    @ApiModelProperty(value = "车型对应的车辆品牌id",required = true)
    @NotNull(message = "[车型对应的车辆品牌id]不能为空")
    private Integer brandId;
    
    @ApiModelProperty(value = "车型对应的车系id",required = true)
    @NotNull(message = "[车系id]不能为空")
    private Integer seriesId;
    
    @ApiModelProperty(value = "车型名称",required = true)
    @NotNull(message = "[车型名称]不能为空")
    private String name;	
    
    @ApiModelProperty(value = "能源类型",required = true)
    @NotNull(message = "[能源类型]不能为空")
    private Integer energyType;

    @ApiModelProperty(value = "油箱容量",required = true)
    private Integer fuelTankCap;
    

    
   

}
