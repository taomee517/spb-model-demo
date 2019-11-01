package com.idea.spbmodeldemo.service;


import com.idea.spbmodeldemo.common.PageVO;
import com.idea.spbmodeldemo.entity.dto.VehicleBrandAliasQueryDTO;
import com.idea.spbmodeldemo.entity.vo.VehicleBrandAliasVO;

import java.util.List;

public interface IVehicleBrandAliasService {

	/**
	 * @Author: taomee517
	 * @methodName:queryBrandByCondition
	 * @Description:根据条件查询品牌分页列表
	 * @Date: 17:07 2019/8/25
	 * @Param: [dto]
	 * @return: com.fzk.terminal.api.vo.VehicleBrandAliasVO
	 * @version: 1.0
	 */
	PageVO<List<VehicleBrandAliasVO>> queryBrandByPage(VehicleBrandAliasQueryDTO dto);


	VehicleBrandAliasVO queryById(Integer brandId);
}
