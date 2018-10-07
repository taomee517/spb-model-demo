package com.idea.spbmodeldemo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.Page;
import com.idea.spbmodeldemo.common.PageVO;
import com.idea.spbmodeldemo.dao.VehicleSeriesPOMapper;
import com.idea.spbmodeldemo.entity.dto.VehicleModelQueryDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleSeriesAddDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleSeriesQueryAllDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleSeriesQueryListDTO;
import com.idea.spbmodeldemo.entity.po.VehicleSeriesPO;
import com.idea.spbmodeldemo.entity.po.VehicleSeriesPOExample;
import com.idea.spbmodeldemo.entity.vo.VehicleModelBaseVO;
import com.idea.spbmodeldemo.entity.vo.VehicleSeriesBaseVO;
import com.idea.spbmodeldemo.entity.vo.VehicleSeriesDetailVO;
import com.idea.spbmodeldemo.entity.vo.VehicleSeriesListVO;
import com.idea.spbmodeldemo.service.IVehicleBrandService;
import com.idea.spbmodeldemo.service.IVehicleModelService;
import com.idea.spbmodeldemo.service.IVehicleSeriesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import org.springframework.util.StringUtils;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/28
 * @描述：车系的持久层 管理service
 * @version：1.0
 */
@Service
public class VehicleSeriesServiceImpl implements IVehicleSeriesService {

    @Autowired
    private VehicleSeriesPOMapper mapper;
    
    @Autowired
    private IVehicleBrandService brandService;
    
    @Autowired
    private IVehicleModelService modelService;

    
    @Override
    public PageVO<List<VehicleSeriesListVO>> selectSeriesByPage(VehicleSeriesQueryListDTO dto) {
    	PageVO<List<VehicleSeriesListVO>> pageVo = new PageVO<List<VehicleSeriesListVO>>();
		List<VehicleSeriesListVO> vos = new ArrayList<VehicleSeriesListVO>();
		VehicleSeriesPOExample example = new VehicleSeriesPOExample();
		VehicleSeriesPOExample.Criteria  criteria = example.createCriteria();
		if(dto.getBrandId()!=null && dto.getBrandId()>0) {
			criteria.andCarCodeLike(dto.getBrandId()+"/%");
		}
		if(!StringUtils.isEmpty(dto.getKeyword())) {
			criteria.andNameLike("%"+dto.getKeyword()+"%");
		}
		Page<VehicleSeriesPO> pageInfo = PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<VehicleSeriesPO> pos = mapper.selectByExample(example);
		if(pos!=null && pos.size()>0) {
			for(VehicleSeriesPO po:pos) {
				VehicleSeriesListVO vo = new VehicleSeriesListVO();
				BeanUtils.copyProperties(po, vo);
				//设置品牌id
				int brandId = Integer.valueOf(po.getCarCode().split("/")[0]);
				vo.setBrandId(brandId);
				//设置品牌名称；
				vo.setBrandName(brandService.queryById(brandId).getName());
				//查询车型数量；
				VehicleModelQueryDTO modelQueryDto = new VehicleModelQueryDTO();
				modelQueryDto.setBrandId(brandId);
				modelQueryDto.setSeriesId(po.getId());
				List<VehicleModelBaseVO> mvos = modelService.queryListByCondition(modelQueryDto);
				if(mvos!=null && mvos.size()>0) {
					vo.setModelNum(mvos.size());
				}else {
					vo.setModelNum(0);
				}				
				//查询车辆数量，待完善；
//				VehicleQueryApiDTO vehicleQueryDto = new VehicleQueryApiDTO();
//				vehicleQueryDto.setBrandId(brandId);
//				vehicleQueryDto.setSeriesId(po.getId());
//				int count = vehicleService.countByDTO(vehicleQueryDto);
//				vo.setVehicleNum(count);
				vos.add(vo);
			}
			pageVo.setCount(pageInfo.getTotal());
			pageVo.setData(vos);
			return pageVo;
		}		
		return null;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Boolean addSeries(VehicleSeriesAddDTO dto) throws Exception{
        VehicleSeriesPO po = new VehicleSeriesPO();
        BeanUtils.copyProperties(dto,po);       
//		int uid =Integer.parseInt(RequstUtil.getToken().getUserId());
		int uid = 1001; //测试时写死
		po.setCrtUid(uid);		
		po.setCrtTime(new Date());			
        int num = mapper.insertSelective(po);
        int id = po.getId();
        po.setCarCode(dto.getBrandId()+"/"+id);
        po.setUpdUid(uid);
        po.setUpdTime(new Date());
        int result = mapper.updateByPrimaryKeySelective(po);
        if (num>0 && result>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Boolean updateSeries(VehicleSeriesAddDTO dto) throws Exception {
    	
        VehicleSeriesPO seriesPO = new VehicleSeriesPO();
//		if(!StringUtils.isEmpty(RequstUtil.getToken().getUserId())) {
//			int uid =Integer.valueOf(RequstUtil.getToken().getUserId());
//			seriesPO.setUpdUid(uid);
//		}
		int uid = 1001; //测试时写死
		seriesPO.setUpdTime(new Date());
        BeanUtils.copyProperties(dto,seriesPO);
        int num = mapper.updateByPrimaryKeySelective(seriesPO);
        //更新车辆车系名称	
        int vStatus = 0;
//  		if(!StringUtils.isEmpty(dto.getName())) {
//  			VehiclePOExample vExample = new VehiclePOExample();
//  			vExample.or().andCarCodeLike(dto.getBrandId()+"/"+dto.getId()+"/%");
//  			VehiclePO vPo = new VehiclePO();
//  			vPo.setSeriesName(dto.getName());
//  			vStatus = vehicleMapper.updateByExampleSelective(vPo, vExample);
//  			if(num>0 && vStatus>0) {
//  				return true;
//  			}
//  		}
        if (num>0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Boolean deleteSeries(Integer id) {
        int num = mapper.deleteByPrimaryKey(id);
        if (num>0){
            return true;
        }
        return false;
    }

    @Override
    public VehicleSeriesDetailVO selectSeriesById(Integer id) {
        VehicleSeriesPO po = mapper.selectByPrimaryKey(id);
        if(po!=null) {
        	VehicleSeriesDetailVO vo = new VehicleSeriesDetailVO();
            BeanUtils.copyProperties(po,vo);
            //设置品牌id
			int brandId = Integer.valueOf(po.getCarCode().split("/")[0]);
			vo.setBrandId(brandId);
			//设置品牌名称；
			vo.setBrandName(brandService.queryById(brandId).getName());
            return vo;
        }
        return null;
    }

    
    @Override
    public List<VehicleSeriesBaseVO> selectSeriesAll(VehicleSeriesQueryAllDTO dto) {
    	VehicleSeriesPOExample example = new VehicleSeriesPOExample();
    	VehicleSeriesPOExample.Criteria criteria = example.createCriteria();
    	if(dto.getId()!=null && dto.getId()>0) {
    		criteria.andIdEqualTo(dto.getId());
    	}
    	if(dto.getBrandId()!=null&& dto.getBrandId()>0) {
    		criteria.andCarCodeLike(dto.getBrandId()+"/%");
    	}
    	if(!StringUtils.isEmpty(dto.getName())) {
    		criteria.andNameEqualTo(dto.getName());
    	}
    	
    	if(!StringUtils.isEmpty(dto.getKeyWord())) {
    		criteria.andNameLike("%"+dto.getKeyWord()+"%");
    	}  	    	
        List<VehicleSeriesPO> pos = mapper.selectByExample(example);
        List<VehicleSeriesBaseVO> vos = new ArrayList<VehicleSeriesBaseVO>();
        if(pos!=null && pos.size()>0) {
        	for(VehicleSeriesPO po:pos) {
        		VehicleSeriesBaseVO vo = new VehicleSeriesBaseVO();
        		BeanUtils.copyProperties(po, vo);
        		vos.add(vo);            	
        	}        	
        }
        return vos;
       
    }
}
