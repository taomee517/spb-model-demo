package com.idea.spbmodeldemo.entity.dto;


import com.idea.spbmodeldemo.common.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/27
 * @描述：查询 车型信息 接口条件数据
 * @version：1.0
 */
@Data
@ApiModel(value = "根据条件查询车型信息",description = "查询 车型信息 接口条件数据")
public class VehicleModelQueryDTO extends PageDTO {

    private static final long serialVersionUID = 6340164518734914818L;

    /**
     * 车系id
     */
    @ApiModelProperty(value = "车系id")
    private Integer seriesId;

    @ApiModelProperty(value = "车型名称模糊查询关键字")
    private String keyword;

    /**
     * 车型对应的车辆品牌id
     */
    @ApiModelProperty(value = "品牌id")
    private Integer brandId;
    
    @ApiModelProperty(value = "车型id")
    private Integer id;
    
    
    


}
