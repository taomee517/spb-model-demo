package com.idea.spbmodeldemo.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/25
 * @描述：车辆品牌信息vo
 * @version：1.0
 */
@Data
@ApiModel(value = "车辆品牌 信息vo",description = "车辆品牌 查询结果vo")
public class VehicleBrandListVO implements Serializable {

    private static final long serialVersionUID = -6058970108962339176L;

    /**
     * 车辆品牌 表id
     */
    @ApiModelProperty(value = "车辆品牌表id")
    private Integer id;

    /**
     * 品牌中文名称
     */
    @ApiModelProperty(value = "品牌中文名称")
    private String name;

    /**
     * 品牌图片地址
     */
    @ApiModelProperty(value = "品牌图片地址")
    private String logo;

    @ApiModelProperty(value = "品牌描述")
    private String description;

    @ApiModelProperty(value = "车系数量")
    private Integer seriesNum;

    @ApiModelProperty(value = "车型数量")
    private Integer modelNum;

    @ApiModelProperty(value = "车辆数量")
    private Integer vehicleNum;


}
