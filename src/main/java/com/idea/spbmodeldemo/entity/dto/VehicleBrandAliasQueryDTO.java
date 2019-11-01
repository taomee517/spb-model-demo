package com.idea.spbmodeldemo.entity.dto;



import com.idea.spbmodeldemo.common.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @项目：mybatis-alias
 * @创建人： taomee517
 * @创建时间： 2018/8/25
 * @描述：分页查询车辆品牌列表dto
 * @version：1.0
 */
@Data
@ApiModel(value = "根据条件分页查询车辆品牌信息",description = "分页查询车辆品牌列表 dto")
public class VehicleBrandAliasQueryDTO extends PageDTO {

    private static final long serialVersionUID = -5884536156642251996L;

    /**
     * 车牌名称
     */
    @ApiModelProperty(value = "车牌名称，支持模糊查询")
    private String keyword;

}
