package com.idea.spbmodeldemo.service;


import com.idea.spbmodeldemo.common.PageVO;
import com.idea.spbmodeldemo.entity.dto.VehicleModelAddDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleModelQueryDTO;
import com.idea.spbmodeldemo.entity.vo.VehicleModelBaseVO;
import com.idea.spbmodeldemo.entity.vo.VehicleModelVO;

import java.util.List;

public interface IVehicleModelService {
	/**
	 * 根据id查询车型名称
	 * @param id
	 * @return
	 */
	String queryNameById(int id);

	/**
	 * @Author: zhangxia
	 * @methodName:addModel
	 * @Description:添加车型 数据
	 * @Date: 10:39 2018/8/27
	 * @Param: [dto]
	 * @return: java.lang.Boolean
	 * @version: 1.0
	 * @throws Exception 
	 */
	Boolean addModel(VehicleModelAddDTO dto) throws Exception;

	/**
	 * @Author: zhangxia
	 * @methodName:queryVehicleModelByCondition
	 * @Description:根据条件查询车牌的车型 数据
	 * @Date: 10:59 2018/8/27
	 * @Param: [dto]
	 * @return: java.util.List<com.fzk.terminal.api.vo.VehicleModelVO>
	 * @version: 1.0
	 */
	PageVO<List<VehicleModelVO>> queryVehicleModelByCondition(VehicleModelQueryDTO dto);
	
	/**
	 * 根据id查询车型信息
	 * @param id
	 * @return
	 */
	VehicleModelAddDTO queryById(Integer id);
	

	/**	
	 * @Description:修改车型 数据	 
	 * @Param: [dto]
	 * @return: java.lang.Boolean
	 * @throws Exception 
	 */
	Boolean updateModel(VehicleModelAddDTO dto) throws Exception;
	
	
	/**	
	 * @Description:删除	 
	 * @Param: [id]
	 * @return: java.lang.Boolean
	 * @throws Exception 
	 */
	Boolean deleteModel(Integer id) ;

	/**
	 * 根据条件查询车型，不分页
	 * @param dto
	 * @return
	 */
	List<VehicleModelBaseVO> queryListByCondition(VehicleModelQueryDTO dto);
	
	/**
	 * 根据条件查询该车型是否存在
	 * @param dto
	 * @return
	 */
	Boolean exist(VehicleModelQueryDTO dto);
}


