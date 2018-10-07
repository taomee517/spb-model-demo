package com.idea.spbmodeldemo.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @项目：fzk-app-monitor
 * @创建人：luotao
 * @创建时间： 2018/8/25
 * @描述：车辆品牌基本信息vo
 * @version：1.0
 */
@Data
@ApiModel(value = "车辆品牌-车系-车型树形结构",description = "品牌-车系-车型查询结果vo")
public class VehicleBrandTreeVO implements Serializable {

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
    
    @ApiModelProperty(value = "该品牌的所有车系")
    private List<VehicleSeriesTreeVO> children;



}
