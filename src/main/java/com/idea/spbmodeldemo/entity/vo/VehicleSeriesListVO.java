package com.idea.spbmodeldemo.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/28
 * @描述：车辆的车系信息实体（用于车辆列表、车辆详情模块的封装）
 * @version：1.0
 */
@Data
@ApiModel(value = "车辆的车系 信息vo",description = "用于车系列表和车系编辑 操作的数据实体vo")
public class VehicleSeriesListVO implements Serializable {

    private static final long serialVersionUID = -5134890816112365760L;

    /**
     * 车系表id
     */
    @ApiModelProperty(value = "车系表id")
    private Integer id;

    @ApiModelProperty(value = "车系名称")
    private String name;

    @ApiModelProperty(value = "品牌id")
    private Integer brandId;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "车系描述")
    private String description;

    @ApiModelProperty(value = "车型数量")
    private Integer modelNum;

    @ApiModelProperty(value = "车辆数量")
    private Integer vehicleNum;

}
