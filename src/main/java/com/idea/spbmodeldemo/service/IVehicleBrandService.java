package com.idea.spbmodeldemo.service;


import com.idea.spbmodeldemo.common.PageVO;
import com.idea.spbmodeldemo.entity.dto.VehicleBrandAddDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleBrandQueryApiDTO;
import com.idea.spbmodeldemo.entity.vo.VehicleBrandBaseVO;
import com.idea.spbmodeldemo.entity.vo.VehicleBrandListVO;
import com.idea.spbmodeldemo.entity.vo.VehicleBrandTreeVO;

import java.util.List;

public interface IVehicleBrandService {

	/**
	 * 根据id查询品牌名称
	 * @param id
	 * @return
	 */
	String queryNameById(int id);

	/**
	 * @Author: zhangxia
	 * @methodName:addBrand
	 * @Description:添加车牌信息
	 * @Date: 16:39 2018/8/25
	 * @Param: [dto]
	 * @return: java.lang.Boolean
	 * @version: 1.0
	 * @throws Exception 
	 */
	Boolean addBrand(VehicleBrandAddDTO dto) throws Exception;

	/**
	 * @Author: zhangxia
	 * @methodName:queryBrandByCondition
	 * @Description:根据条件查询车牌车型信息
	 * @Date: 17:07 2018/8/25
	 * @Param: [dto]
	 * @return: com.fzk.terminal.api.vo.VehicleBrandListVO
	 * @version: 1.0
	 */
	PageVO<List<VehicleBrandListVO>> queryBrandByPage(VehicleBrandQueryApiDTO dto);
	
	/**
	 * 根据名称查询品牌是否存在
	 * @param dto
	 * @return
	 */
	List<VehicleBrandBaseVO> queryBrandByDto(VehicleBrandQueryApiDTO dto);
	
	/**
	 * 根据id获取品牌信息
	 * @param id
	 * @return
	 */
	VehicleBrandAddDTO queryById(Integer id);
	
	/**
	 * 更新品牌信息
	 * @param dto
	 * @return
	 * @throws Exception 
	 */
	Boolean updateBrandInfo(VehicleBrandAddDTO dto) throws Exception;
	
	/**
	 * 根据id删除品牌
	 * @param id
	 * @return
	 */
	Boolean delete(Integer id);
	
	/**
	 * 获取所有品牌，下拉列表接口
	 * @return
	 */
	List<VehicleBrandBaseVO> queryAll();
	
	/**
	 * 获取所有品牌-车系-车型，下拉列表接口
	 * @return
	 */
	List<VehicleBrandTreeVO> selectModelTree();


}
