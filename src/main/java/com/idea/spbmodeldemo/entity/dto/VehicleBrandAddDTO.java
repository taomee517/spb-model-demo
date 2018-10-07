package com.idea.spbmodeldemo.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/25
 * @描述：添加车辆品牌信息 tb_vehicle_brand
 * @version：1.0
 */
@Data
@ApiModel(value = "添加车辆品牌信息",description = "zhangxia 添加车辆品牌信息 dto")
public class VehicleBrandAddDTO implements Serializable {

    private static final long serialVersionUID = 6665118085938608228L;
    
    @ApiModelProperty(value = "品牌id")
    private Integer Id;

    /**
     * 品牌中文名称
     */
    @ApiModelProperty(value = "品牌中文名称",dataType = "string",required = true)
    @NotEmpty(message = "[品牌名称]不能为空")
    private String name;

    /**
     * 品牌图片(url地址)
     */
    @ApiModelProperty(value = "品牌图片(url地址)",dataType = "string",required = true)
    @NotEmpty(message = "[品牌图片]不能为空")
    private String logo;

    @ApiModelProperty(value = "品牌描述",dataType = "string",required = true)
    private String description;

}
