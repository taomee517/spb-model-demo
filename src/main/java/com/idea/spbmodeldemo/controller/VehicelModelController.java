package com.idea.spbmodeldemo.controller;

import java.util.List;

import javax.validation.Valid;

import com.idea.spbmodeldemo.common.*;
import com.idea.spbmodeldemo.entity.dto.VehicleModelAddDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleModelQueryDTO;
import com.idea.spbmodeldemo.entity.vo.VehicleModelBaseVO;
import com.idea.spbmodeldemo.entity.vo.VehicleModelVO;
import com.idea.spbmodeldemo.service.IVehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/27
 * @描述：车辆的车型 controller
 * @version：1.0
 */
@RestController
@RequestMapping("/model")
@Api(value = "车型Model",description = "车型CRUD,树形结构")
public class VehicelModelController{

    @Autowired
    private IVehicleModelService modelService;

    /**
     * @Author: zhangxia
     * @methodName:addModel
     * @Description:添加车辆的车型
     * @Date: 11:39 2018/8/27
     * @Param: [dto]
     * @return: com.ms.basedto.result.ResponseModel<java.lang.Boolean>
     * @version: 1.0
     */
    @SuppressWarnings({ "unchecked", "static-access"})
	@ApiOperation(value = "车型添加")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseModel<Boolean> addModel(@RequestBody @Valid VehicleModelAddDTO dto , BindingResult bindResult) {
        try {
        	//参数校验
        	if(bindResult.hasErrors()) {
        		return ResultUtils.me.error(StatusCode.S_PARAM_ERROR, bindResult.getAllErrors().get(0).getDefaultMessage());
        	}
        	if(dto.getEnergyType()!= EnergyType.T_ELECTRIC.getCode()) {
        		if(dto.getFuelTankCap()==null||dto.getFuelTankCap()<=0) {
        			return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"燃油车油箱容量不能为空！");
        		}
        	}
        	if(dto.getName().contains("/")||dto.getName().contains(",")) {
        		return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"车型名称不要包含'/'或',' ");
        	}
        	//新增前判断是否已经存在该车型
            VehicleModelQueryDTO queryDTO = new VehicleModelQueryDTO();
            queryDTO.setBrandId(dto.getBrandId());
            queryDTO.setSeriesId(dto.getSeriesId());
            queryDTO.setKeyword(dto.getName());            
            if (modelService.exist(queryDTO)){
                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"车型名称已经存在",false);
            } else {
                Boolean b = modelService.addModel(dto);
                if (b){
                    return ResultUtils.ok();
                }else {
                	return ResultUtils.fail();
                }
            }
        } catch (Exception e) {
            return ResultUtils.me.error(StatusCode.S_EXCEPTION,"添加车型信息 处理异常",false);
        }     
    }

    /**
     * @Author: zhangxia
     * @methodName:queryModelByCondition
     * @Description:根据条件查询车型列表
     * @Date: 11:23 2018/8/27
     * @Param: [dto]
     * @return: com.ms.basedto.result.ResponseModel<java.util.List<com.fzk.terminal.api.vo.VehicleModelVO>>
     * @version: 1.0
     */
    @SuppressWarnings("unchecked")
	@ApiOperation(value = "车型列表")
    @RequestMapping(value = "/query",method = RequestMethod.POST)    
    public ResponseModel<PageVO<List<VehicleModelVO>>> queryModelByCondition(@RequestBody VehicleModelQueryDTO dto) {
        try {
        	PageVO<List<VehicleModelVO>> pageVo = modelService.queryVehicleModelByCondition(dto);
            return ResultUtils.me.success(pageVo);
        } catch (Exception e) {
            return ResultUtils.me.error(StatusCode.S_EXCEPTION,"查询车型列表 处理异常",e);
        }
    }

	@SuppressWarnings({ "unchecked", "static-access" })
	
	@ApiOperation(value = "根据id查询车型信息")
    @RequestMapping(value = "/info",method = RequestMethod.POST)
	public ResponseModel<VehicleModelAddDTO> getInfo(@RequestBody Integer id) {
		try {
			VehicleModelAddDTO dto = modelService.queryById(id);
			if(dto==null) {
            	return ResultUtils.me.error(StatusCode.S_PARAM_ERROR, "该车型不存在");
            }
            return ResultUtils.me.success(dto);
        } catch (Exception e) {
            return ResultUtils.me.error(StatusCode.S_EXCEPTION,"查询车型信息 处理异常",e);
        }
	}

	@SuppressWarnings({ "unchecked", "static-access" })	
	@ApiOperation(value = "车型修改")
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
	public ResponseModel<Boolean> edit(@RequestBody VehicleModelAddDTO dto) {
		try {
			//参数验证
//			if (Objects.isNull(dto.getId())||dto.getId()<=0){
//                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"车型id参数有误",false);
//            }
			//判断该id对应的车型是否存在
			VehicleModelAddDTO infoDto = modelService.queryById(dto.getId());
			if(infoDto==null) {
            	return ResultUtils.me.error(StatusCode.S_PARAM_ERROR, "该车型不存在",false);
            }
			if(dto.getName()!=null) {
				if(dto.getName().contains("/")||dto.getName().contains(",")) {
	        		return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"车型名称不要包含'/'或',' ");
	        	}
			}
			 //验证修改后的车型是否重复
			VehicleModelQueryDTO queryDto = new VehicleModelQueryDTO();
			queryDto.setBrandId(dto.getBrandId());
			queryDto.setSeriesId(dto.getSeriesId());
			queryDto.setKeyword(dto.getName());
			List<VehicleModelBaseVO> vos = modelService.queryListByCondition(queryDto);
			if(!CollectionUtils.isEmpty(vos) && !(vos.get(0).getId().equals(dto.getId()))) {
				return ResultUtils.me.error(StatusCode.S_PARAM_ERROR, "该车型已存在，请勿重复",false);
			}
			 Boolean b = modelService.updateModel(dto);
	         if (b){
	             return ResultUtils.ok();
	         }else {
	         	return ResultUtils.fail();
	         }
		} catch (Exception e) {
            return ResultUtils.me.error(StatusCode.S_EXCEPTION,"查询车型信息 处理异常",false);
        }
	}

	@SuppressWarnings("unchecked")	
	@ApiOperation(value = "车型删除")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
	public ResponseModel<Boolean> delete(@RequestBody Integer id) {
		try {
			VehicleModelAddDTO modelDto = modelService.queryById(id);
			if(modelDto==null) {
				return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该车型不存在！",false);
			}
			//删除操作前先判断该车型下是否有车
//			VehicleListQueryDTO vehicleQueryDto = new VehicleListQueryDTO();
//	        vehicleQueryDto.setBrandId(modelDto.getBrandId());
//	        vehicleQueryDto.setSeriesId(modelDto.getSeriesId());
//	        vehicleQueryDto.setModelId(id);
//	        long count = vService.countByCondition(vehicleQueryDto);
//			if(count>0) {
//				return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该车型尚有车辆运营，不能删除！",false);
//			}
			Boolean b = modelService.deleteModel(id);
	        if (b){
	            return ResultUtils.ok();
	        }else {
	        	return ResultUtils.fail();
	        }
		} catch (Exception e) {
           return ResultUtils.me.error(StatusCode.S_EXCEPTION,"查询车型信息 处理异常",false);
       }
	}

	@SuppressWarnings({ "unchecked", "static-access" })	
	@ApiOperation(value = "所有车型")
    @RequestMapping(value = "/all",method = RequestMethod.POST)
	public ResponseModel<List<VehicleModelBaseVO>> all(@RequestBody VehicleModelQueryDTO dto) {
		try {
			List<VehicleModelBaseVO> vos = modelService.queryListByCondition(dto);
			return ResultUtils.me.success(vos);
		} catch (Exception e) {
	        return ResultUtils.me.error(StatusCode.S_EXCEPTION,"获取所有车型 处理异常");
	    }				
	}
}
