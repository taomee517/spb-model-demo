package com.idea.spbmodeldemo.controller;


import com.idea.spbmodeldemo.common.PageVO;
import com.idea.spbmodeldemo.common.ResponseModel;
import com.idea.spbmodeldemo.common.ResultUtils;
import com.idea.spbmodeldemo.common.StatusCode;
import com.idea.spbmodeldemo.entity.dto.VehicleBrandAliasQueryDTO;
import com.idea.spbmodeldemo.entity.vo.VehicleBrandAliasVO;
import com.idea.spbmodeldemo.service.IVehicleBrandAliasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brandAlias")
@Api(value = "品牌Brand关联查询接口",description = "关联查询验证")
@Slf4j
public class VehicleBrandAliasController {

    @Autowired
    IVehicleBrandAliasService brandAliasService;


    @ApiOperation(value = "根据条件查询品牌列表",notes = "关键字查询")
    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public ResponseModel<PageVO<List<VehicleBrandAliasVO>>> queryBrandByPage(@RequestBody VehicleBrandAliasQueryDTO dto){
        try {
            PageVO<List<VehicleBrandAliasVO>> pageModel = brandAliasService.queryBrandByPage(dto);
            return ResultUtils.me.success(pageModel);
        } catch (Exception e) {
            log.info("根据条件分页查询 品牌列表 服务端处理异常e={}",e);
            return ResultUtils.error(StatusCode.S_EXCEPTION,"根据条件查询 品牌列表 处理异常");
        }
    }


    @ApiOperation(value = "根据id查询品牌",notes = "id查询")
    @RequestMapping(value = "/info/{brandId}",method = {RequestMethod.GET})
    public ResponseModel<VehicleBrandAliasVO> queryById(@PathVariable("brandId") int brandId){
        try {
            VehicleBrandAliasVO brandAliasVO = brandAliasService.queryById(brandId);
            return ResultUtils.me.success(brandAliasVO);
        } catch (Exception e) {
            log.info("根据id查询品牌时 服务端处理异常e={}",e);
            return ResultUtils.error(StatusCode.S_EXCEPTION,"根据id查询品牌时服务端处理异常");
        }
    }
}
