package com.idea.spbmodeldemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.idea.spbmodeldemo.common.PageVO;
import com.idea.spbmodeldemo.dao.VehicleBrandAliasPOMapper;
import com.idea.spbmodeldemo.entity.dto.VehicleBrandAliasQueryDTO;
import com.idea.spbmodeldemo.entity.po.VehicleBrandAliasPOExample;
import com.idea.spbmodeldemo.entity.po.VehicleBrandPO;
import com.idea.spbmodeldemo.entity.vo.VehicleBrandAliasVO;
import com.idea.spbmodeldemo.service.IVehicleBrandAliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class VehicleBrandAliasServiceImpl implements IVehicleBrandAliasService {

    @Autowired
    VehicleBrandAliasPOMapper brandAliasPOMapper;

    @Override
    public PageVO<List<VehicleBrandAliasVO>> queryBrandByPage(VehicleBrandAliasQueryDTO dto) {
        PageVO<List<VehicleBrandAliasVO>> pageVo = new PageVO<List<VehicleBrandAliasVO>>();
        VehicleBrandAliasPOExample example = new VehicleBrandAliasPOExample();
        if(!StringUtils.isEmpty(dto.getKeyword())) {
            example.createCriteria().andNameLike("%"+dto.getKeyword()+"%");
        }
        Page<VehicleBrandPO> pageInfo = PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        List<VehicleBrandAliasVO> vos = brandAliasPOMapper.selectByAliasExample(example);
        pageVo.setCount(pageInfo.getTotal());
        pageVo.setData(vos);
        return pageVo;
    }


    @Override
    public VehicleBrandAliasVO queryById(Integer brandId) {
        return brandAliasPOMapper.selectByAliasPrimaryKey(brandId);
    }
}
