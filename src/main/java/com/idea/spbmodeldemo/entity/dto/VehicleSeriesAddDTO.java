package com.idea.spbmodeldemo.entity.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/28
 * @描述：添加车辆车系 dto
 * @version：1.0
 */
@Data
@ApiModel(value = "添加/编辑 车辆 车系 信息",description = "用于 添加/编辑车辆的车系 信息接口 封装数据实体")
public class VehicleSeriesAddDTO implements Serializable {

    private static final long serialVersionUID = 553856119688254936L;

    /**
     * 车系表id
     */
    @ApiModelProperty(value = "车系表id  车系编辑时不能为空")
    private Integer id;

    /**
     * 车辆品牌表id
     */
    @ApiModelProperty(value = "车辆品牌表id",required = true)
    @NotNull(message = "[车辆品牌表id]不能为空")
    private Integer brandId;

    /**
     * 车系名称
     */
    @ApiModelProperty(value = "车系名称",required = true)
    @NotNull(message = "[车系名称]不能为空")
    private String name;

    /**
     * 车系描述
     */
    @ApiModelProperty(value = "车系描述")
    private String description;

}
