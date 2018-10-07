package com.idea.spbmodeldemo.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.idea.spbmodeldemo.common.PageVO;
import com.idea.spbmodeldemo.common.ResponseModel;
import com.idea.spbmodeldemo.common.ResultUtils;
import com.idea.spbmodeldemo.common.StatusCode;
import com.idea.spbmodeldemo.entity.dto.VehicleModelQueryDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleSeriesAddDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleSeriesQueryAllDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleSeriesQueryListDTO;
import com.idea.spbmodeldemo.entity.vo.VehicleModelBaseVO;
import com.idea.spbmodeldemo.entity.vo.VehicleSeriesBaseVO;
import com.idea.spbmodeldemo.entity.vo.VehicleSeriesDetailVO;
import com.idea.spbmodeldemo.entity.vo.VehicleSeriesListVO;
import com.idea.spbmodeldemo.service.IVehicleModelService;
import com.idea.spbmodeldemo.service.IVehicleSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/28
 * @描述：车辆的车系 controller
 * @version：1.0
 */
@RestController
@RequestMapping("/series")
@Api(value = "车系Series接口",description = "车系CRUD")
@Slf4j
public class VehicleSeriesController{

    @Autowired
    private IVehicleSeriesService seriesService;
    
    @Autowired
    private IVehicleModelService modelService;
    
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "车系列表")
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public ResponseModel<PageVO<List<VehicleSeriesListVO>>> querySeriesByPage(@RequestBody VehicleSeriesQueryListDTO dto) {

        try {
//            //验证权限
//            JwtToken jwtToken = RequstUtil.getToken();
//            if (!UserTypeEnum.MANAGER.getDesc().equals(jwtToken.getUserType())){
//                return ResultUtils.me.error(StatusCode.S_SIGN_FAIL,"对不起，您没有权限！");
//            } //测试时开放权限
            PageVO<List<VehicleSeriesListVO>> listPageVO = seriesService.selectSeriesByPage(dto);
            return ResultUtils.me.success(listPageVO);
        } catch (Exception e) {
            log.info("根据条件分页查询 车辆的车系列表 服务端处理异常e={}",e);
            return ResultUtils.error(StatusCode.S_EXCEPTION,"服务端处理异常");
        }
    }
    
    @SuppressWarnings({ "unchecked", "static-access" })
    @ApiOperation(value = "根据id查询车系")
    @RequestMapping(value = "/info",method = {RequestMethod.POST})
    public ResponseModel<VehicleSeriesDetailVO> getInfo(@RequestBody Integer id) {
        try {
            //验证权限
//            JwtToken jwtToken = RequstUtil.getToken();
//            if (!UserTypeEnum.MANAGER.getDesc().equals(jwtToken.getUserType())){
//                return ResultUtils.me.error(StatusCode.S_SIGN_FAIL,"对不起，您没有权限！");
//            } //测试时开放权限
            if (Objects.isNull(id)||id<=0){
                return ResultUtils.error(StatusCode.S_PARAM_ERROR,"请求参数有误");
            }
            VehicleSeriesDetailVO detailVO = seriesService.selectSeriesById(id);
            if(detailVO==null) {
            	return ResultUtils.me.error(StatusCode.S_EXCEPTION, "该车系不存在");
            }
            return ResultUtils.me.success(detailVO);
        } catch (Exception e) {
            log.info("根据条件获取车系详情 服务端处理异常e={}",e);
            return ResultUtils.error(StatusCode.S_EXCEPTION,"服务端处理异常");
        }
    }

    @SuppressWarnings({ "unchecked", "static-access" })
    @ApiOperation(value = "车系添加")
    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public ResponseModel<Boolean> addSeries(@RequestBody @Valid VehicleSeriesAddDTO dto , BindingResult result) {
        try {
            //验证权限
//            JwtToken jwtToken = RequstUtil.getToken();
//            if (!UserTypeEnum.MANAGER.getDesc().equals(jwtToken.getUserType())){
//                return ResultUtils.me.error(StatusCode.S_SIGN_FAIL,"对不起，您没有权限！",false);
//            } //测试时跳过权限
            //验证参数
//            String message = dto.validateForm();
//            if (StringUtils.isNotEmpty(message)){
//                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,message,false);
//            }
        	if(result.hasErrors()) {
        		return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,result.getAllErrors().get(0).getDefaultMessage(),false);
        	}
        	if(dto.getName()!=null) {
				if(dto.getName().contains("/")||dto.getName().contains(",")) {
	        		return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"车系名称不要包含'/'或',' ");
	        	}
			}
            //验证是否重复
            VehicleSeriesQueryAllDTO allDTO = new VehicleSeriesQueryAllDTO();
            allDTO.setBrandId(dto.getBrandId());
            allDTO.setName(dto.getName());
            List<VehicleSeriesBaseVO> allVOS = seriesService.selectSeriesAll(allDTO);
            if (!CollectionUtils.isEmpty(allVOS)){
                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该车系已经存在",false);
            }
            Boolean b = seriesService.addSeries(dto);
            if (b){
                return ResultUtils.ok();
            }
            return ResultUtils.fail();
        } catch (Exception e) {
            log.info("添加车辆的车系 服务端处理异常e={}",e);
            return ResultUtils.me.error(StatusCode.S_EXCEPTION,"服务端处理异常",false);
        }
    }

    

    /**
     * @Author: zhangxia
     * @methodName:editSeries
     * @Description:编辑车辆的车系
     * @Date: 19:18 2018/8/28
     * @Param: [dto]
     * @return: com.ms.basedto.result.ResponseModel<java.lang.Boolean>
     * @version: 1.0
     */
    @SuppressWarnings({ "unchecked", "static-access" })
    @ApiOperation(value = "车系更新")
    @RequestMapping(value = "/edit",method = {RequestMethod.POST})
    public ResponseModel<Boolean> editSeries(@RequestBody VehicleSeriesAddDTO dto) {
        try {
            //验证权限
//            JwtToken jwtToken = RequstUtil.getToken();
//            if (!UserTypeEnum.MANAGER.getDesc().equals(jwtToken.getUserType())){
//                return ResultUtils.me.error(StatusCode.S_SIGN_FAIL,"对不起，您没有权限！",false);
//            } //测试时跳过权限
            //验证参数
//            String message = dto.validateForm();
//            if (StringUtils.isNotEmpty(message)){
//                return ResultUtils.error(StatusCode.S_PARAM_ERROR,message);
//            } //测试时跳过参数校验
            if (Objects.isNull(dto.getId())||dto.getId()==0){
                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"车系id参数有误",false);
            }
            if(dto.getName()!=null) {
				if(dto.getName().contains("/")||dto.getName().contains(",")) {
	        		return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"车系名称不要包含'/'或',' ");
	        	}
			}           
            //验证是否该id对应的车系是否存在
            if (Objects.isNull(seriesService.selectSeriesById(dto.getId()))){
                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"对应的id数据不存在",false);
            }
            //验证是否重复
            VehicleSeriesQueryAllDTO allDTO = new VehicleSeriesQueryAllDTO();
            allDTO.setBrandId(dto.getBrandId());
            allDTO.setName(dto.getName());
            List<VehicleSeriesBaseVO> allVOS = seriesService.selectSeriesAll(allDTO);
            if (!CollectionUtils.isEmpty(allVOS) && !(allVOS.get(0).getId().equals(dto.getId()))){
                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该车系已经存在",false);
            }
            Boolean b = seriesService.updateSeries(dto);
            if (b){
                return ResultUtils.ok();
            }
            return ResultUtils.fail();
        } catch (Exception e) {
            log.info("编辑车辆的车系 服务端处理异常e={}",e);
            return ResultUtils.me.error(StatusCode.S_EXCEPTION,"服务端处理异常",false);
        }
    }
    
    /**
     * @Author: zhangxia
     * @methodName:deleteSeries
     * @Description:物理删除车系数据(物理删除，注意：有车辆或车型配置引用的车系不能删除) 接口
     * @Date: 19:43 2018/8/28
     * @Param: [dto]
     * @return: com.ms.basedto.result.ResponseModel<java.lang.Boolean>
     * @version: 1.0
     */
    @SuppressWarnings({ "unchecked" })
	@ApiOperation(value = "车系删除")
    @RequestMapping(value = "/delete",method = {RequestMethod.POST})
    public ResponseModel<Boolean> deleteSeries(@RequestBody Integer id) {
        try {
            //验证权限
//            JwtToken jwtToken = RequstUtil.getToken();
//            if (!UserTypeEnum.MANAGER.getDesc().equals(jwtToken.getUserType())){
//                return ResultUtils.me.error(StatusCode.S_SIGN_FAIL,"对不起，您没有权限！",false);
//            } //测试时跳过权限
            if (Objects.isNull(id)||id<=0){
                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"请求参数有误",false);
            }
            //验证数据是否存在
            VehicleSeriesDetailVO vo = seriesService.selectSeriesById(id);
            if (Objects.isNull(vo)){
                return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该车系不存在",false);
            }
            //验证该车系下是否有车型
            int brandId = seriesService.selectSeriesById(id).getBrandId();
            VehicleModelQueryDTO modelQueryDto = new VehicleModelQueryDTO();
            modelQueryDto.setBrandId(brandId);
            modelQueryDto.setSeriesId(id);
            List<VehicleModelBaseVO> modelVos = modelService.queryListByCondition(modelQueryDto);
            if(!CollectionUtils.isEmpty(modelVos)) {
            	 return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该车系下存在车型，不能删除！",false);
            }
            //验证该车系下是否有车辆 ,待完善
//            VehicleListQueryDTO vehicleQueryDto = new VehicleListQueryDTO();
//	        vehicleQueryDto.setBrandId(vo.getBrandId());
//	        vehicleQueryDto.setSeriesId(id);
//	        long count = vehicleService.countByCondition(vehicleQueryDto);
//	        if(count>0) {
//				return ResultUtils.me.error(StatusCode.S_PARAM_ERROR,"该车系尚有车辆运营，不能删除！",false);
//			}
            //以上条件排除后，删除数据
            Boolean b = seriesService.deleteSeries(id);
            if (b){
                return ResultUtils.ok();
            }
            return ResultUtils.fail();
        } catch (Exception e) {
            log.info("删除车辆的车系 服务端处理异常e={}",e);
            return ResultUtils.me.error(StatusCode.S_EXCEPTION,"服务端处理异常",false);
        }
    }

    

    @SuppressWarnings({ "unchecked" })
    @ApiOperation(value = "获取所有车系")
    @RequestMapping(value = "/all",method = {RequestMethod.POST})
    public ResponseModel<List<VehicleSeriesBaseVO>> getAllSeries(@RequestBody VehicleSeriesQueryAllDTO dto) {
        try {
            //验证权限
//            JwtToken jwtToken = RequstUtil.getToken();
//            if (!UserTypeEnum.MANAGER.getDesc().equals(jwtToken.getUserType())){
//                return ResultUtils.me.error(StatusCode.S_SIGN_FAIL,"对不起，您没有权限！");
//            } //测试时跳过权限
            List<VehicleSeriesBaseVO> vehicleSeriesAllVOS = seriesService.selectSeriesAll(dto);
            return ResultUtils.me.success(vehicleSeriesAllVOS);
        } catch (Exception e) {
            log.info("获取所有车辆的车系 服务端处理异常e={}",e);
            return ResultUtils.error(StatusCode.S_EXCEPTION,"服务端处理异常");
        }
    }


}
