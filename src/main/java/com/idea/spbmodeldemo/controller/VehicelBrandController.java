package com.idea.spbmodeldemo.controller;


import com.idea.spbmodeldemo.common.PageVO;
import com.idea.spbmodeldemo.common.ResponseModel;
import com.idea.spbmodeldemo.common.ResultUtils;
import com.idea.spbmodeldemo.common.StatusCode;
import com.idea.spbmodeldemo.entity.dto.VehicleBrandAddDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleBrandQueryApiDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleModelQueryDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleSeriesQueryAllDTO;
import com.idea.spbmodeldemo.entity.vo.*;
import com.idea.spbmodeldemo.service.IVehicleBrandService;
import com.idea.spbmodeldemo.service.IVehicleModelService;
import com.idea.spbmodeldemo.service.IVehicleSeriesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/27
 * @描述：车辆品牌controller
 * @version：1.0
 */
@RestController
@RequestMapping("/brand")
@Api(value = "品牌Brand接口",description = "品牌分类，树形结构")
@Slf4j
public class VehicelBrandController {

    @Autowired
    private IVehicleBrandService brandService;
    
    @Autowired
    private IVehicleSeriesService seriesService;
    
    @Autowired
    private IVehicleModelService modelService;

    /**
     * @Author: zhangxia
     * @methodName:addBrand
     * @Description:添加车牌信息
     * @Date: 9:22 2018/8/27
     * @Param: [dto]
     * @return: com.ms.basedto.result.ResponseModel<java.lang.Boolean>
     * @version: 1.0
     */
    @SuppressWarnings({ "unchecked", "static-access" })
	@ApiOperation(value = "添加品牌",notes = "新增")
    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public ResponseModel<Boolean> addBrand(@RequestBody @Valid VehicleBrandAddDTO dto, BindingResult validResult){
        ResponseModel<Boolean> result =  ResultUtils.fail();
        try {
            //验证权限
//            JwtToken jwtToken = RequstUtil.getToken();
//            if (!UserTypeEnum.MANAGER.getDesc().equals(jwtToken.getUserType())){
//                return ResultUtils.me.error(StatusCode.S_SIGN_FAIL,"对不起，您没有权限！");
//            } 测试时跳过权限
            //验证参数
//            String message = dto.validateForm();
//            if (StringUtils.isNotEmpty(message)){
//                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,message,false);
//            }
        	if(validResult.hasErrors()) {
        		return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,validResult.getAllErrors().get(0).getDefaultMessage(),false);
        	}
        	if(dto.getName()!=null) {
				if(dto.getName().contains("/")||dto.getName().contains(",")) {
	        		return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"品牌名称不要包含'/'或',' ");
	        	}
			}  
            //验证是否重复
            VehicleBrandQueryApiDTO queryDTO = new VehicleBrandQueryApiDTO();
            queryDTO.setKeyword(dto.getName());
            if (brandService.queryBrandByDto(queryDTO)!=null && brandService.queryBrandByDto(queryDTO).size()>0){
                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该品牌已经存在",false);
            }
            Boolean b = brandService.addBrand(dto);
            if (b){
                result =  ResultUtils.ok();
            }
        } catch (Exception e) {
            result = ResultUtils.me.error(StatusCode.S_EXCEPTION,"添加车牌信息 处理异常",false);
        }

        return result;
    }

    /**
     * @Author: zhangxia
     * @methodName:queryBrandByCondition
     * @Description:根据条件查询车牌车型信息
     * @Date: 9:30 2018/8/27
     * @Param: [dto]
     * @return: com.ms.basedto.result.ResponseModel<com.fzk.terminal.api.vo.VehicleBrandListVO>
     * @version: 1.0
     */
    @SuppressWarnings("unchecked")
	@ApiOperation(value = "根据条件查询品牌列表",notes = "查询")
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public ResponseModel<PageVO<List<VehicleBrandListVO>>> queryBrandByPage(@RequestBody VehicleBrandQueryApiDTO dto){
        try {
        	PageVO<List<VehicleBrandListVO>> vehicleBrandVO = brandService.queryBrandByPage(dto);
        	return ResultUtils.me.success(vehicleBrandVO);           
        } catch (Exception e) {
        	log.info("根据条件分页查询 品牌列表 服务端处理异常e={}",e);
        	return ResultUtils.error(StatusCode.S_EXCEPTION,"根据条件查询 品牌列表 处理异常");
        }
    }

	@SuppressWarnings("unchecked")
	@ApiOperation(value = "根据id查询品牌信息",notes = "查询")
    @RequestMapping(value = "/info",method = {RequestMethod.POST})
	public ResponseModel<VehicleBrandAddDTO> getBrandInfo(@RequestBody Integer id) {
		 try {
			 	if(id==null || id<=0) {
			 		return ResultUtils.error(StatusCode.S_EXCEPTION,"品牌id,参数错误！");
			 	}
			 	VehicleBrandAddDTO dto = brandService.queryById(id);
	        	return ResultUtils.me.success(dto);           
	        } catch (Exception e) {
	        	log.info("根据id查询品牌信息 服务端处理异常e={}",e);
	        	return ResultUtils.error(StatusCode.S_EXCEPTION,"根据id查询品牌信息 处理异常");
	        }
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	@ApiOperation(value = "编辑品牌信息",notes = "更新")
    @RequestMapping(value = "/edit",method = {RequestMethod.POST})
	public ResponseModel<Boolean> edit(@RequestBody VehicleBrandAddDTO dto) {
		try {
            //验证权限
//            JwtToken jwtToken = RequstUtil.getToken();
//            if (!UserTypeEnum.MANAGER.getDesc().equals(jwtToken.getUserType())){
//                return ResultUtils.me.error(StatusCode.S_SIGN_FAIL,"对不起，您没有权限！");
//            } //测试时跳过权限
            if (Objects.isNull(dto.getId())||dto.getId()==0){
                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"品牌id参数有误",false);
            }
            //验证是否该id对应的品牌是否存在
            if (Objects.isNull(brandService.queryById(dto.getId()))){
                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该品牌不存在",false);
            }
            if(dto.getName()!=null) {
				if(dto.getName().contains("/")||dto.getName().contains(",")) {
	        		return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"品牌名称不要包含'/'或',' ");
	        	}
			} 
            //验证是否重复
            VehicleBrandQueryApiDTO queryDto = new VehicleBrandQueryApiDTO();
            queryDto.setKeyword(dto.getName());
            List<VehicleBrandBaseVO> vos = brandService.queryBrandByDto(queryDto);
            if (!CollectionUtils.isEmpty(vos) && !(vos.get(0).getId().equals(dto.getId()))){
                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该品牌已经存在",false);
            }
            Boolean b = brandService.updateBrandInfo(dto);
            if (b){
                return ResultUtils.ok();
            }
            return ResultUtils.fail();
        } catch (Exception e) {
            log.info("编辑车辆品牌时 服务端处理异常e={}",e);
            return ResultUtils.me.error(StatusCode.S_EXCEPTION,"服务端处理异常",false);
        }
	}

	@SuppressWarnings({ "unchecked"})
	@ApiOperation(value = "品牌删除",notes = "删除")
    @RequestMapping(value = "/delete",method = {RequestMethod.POST})
	public ResponseModel<Boolean> delete(@RequestBody Integer id) {
		try {
	        //验证权限
//	        JwtToken jwtToken = RequstUtil.getToken();
//	        if (!UserTypeEnum.MANAGER.getDesc().equals(jwtToken.getUserType())){
//	            return ResultUtils.me.error(StatusCode.S_SIGN_FAIL,"对不起，您没有权限！");
//	        } 
			 //验证该品牌是否存在
	        VehicleBrandAddDTO dto = brandService.queryById(id);
	        if (Objects.isNull(dto)){
	            return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该品牌不存在",false);
	        }
	        //验证该品牌下是否有车系
	        VehicleSeriesQueryAllDTO allDTO = new VehicleSeriesQueryAllDTO();
	        allDTO.setBrandId(id);
	        List<VehicleSeriesBaseVO> allVOS = seriesService.selectSeriesAll(allDTO);
	        if (!CollectionUtils.isEmpty(allVOS)){
	            return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该品牌下存在车系，不能删除！",false);
	        }
	        //验证该品牌下是否有车型
	        VehicleModelQueryDTO modelQueryDto = new VehicleModelQueryDTO();
	        modelQueryDto.setBrandId(id);
	        List<VehicleModelBaseVO> modelVos = modelService.queryListByCondition(modelQueryDto);
	        if(!CollectionUtils.isEmpty(modelVos)) {
	        	 return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该品牌下存在车型，不能删除！",false);
	        }
	        //验证该品牌下是否有车辆 
//	        VehicleListQueryDTO vehicleQueryDto = new VehicleListQueryDTO();
//	        vehicleQueryDto.setBrandId(id);
//	        long count = vehicleService.countByCondition(vehicleQueryDto);
//		    if(count!=0) {
//		    	return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该品牌尚有车辆运营，不能删除！",false);
//		    }
	        //以上条件排除后，删除数据
	        Boolean b = brandService.delete(id);
	        if (b){
	            return ResultUtils.ok();
	        }
	        return ResultUtils.fail();
	    } catch (Exception e) {
	        log.info("删除品牌 服务端处理异常e={}",e);
	        return ResultUtils.me.error(StatusCode.S_EXCEPTION,"删除品牌时 服务端处理异常",false);
		}
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	@ApiOperation(value = "获取所有品牌",notes = "查询")
    @RequestMapping(value = "/all",method = {RequestMethod.POST})
	public ResponseModel<List<VehicleBrandBaseVO>> getAll() {
		try {
			List<VehicleBrandBaseVO> vos = brandService.queryAll();
			return ResultUtils.me.success(vos);
		} catch (Exception e) {
	        log.info("获取所有品牌 服务端处理异常e={}",e);
	        return ResultUtils.me.error(StatusCode.S_EXCEPTION,"删除品牌时 服务端处理异常");
		}
	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	@ApiOperation(value = "获取所有品牌-车系-车型",notes = "树结构")
    @RequestMapping(value = "/tree",method = {RequestMethod.GET})
	public ResponseModel<List<VehicleBrandTreeVO>> getModelTree() {
		try {
			List<VehicleBrandTreeVO> vos = brandService.selectModelTree();
			return ResultUtils.me.success(vos);
		} catch (Exception e) {
	        log.info("获取所有品牌 服务端处理异常e={}",e);
	        return ResultUtils.me.error(StatusCode.S_EXCEPTION,"删除品牌时 服务端处理异常");
		}
	}
}
