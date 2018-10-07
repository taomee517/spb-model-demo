package com.idea.spbmodeldemo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.Page;
import com.idea.spbmodeldemo.common.EnergyType;
import com.idea.spbmodeldemo.common.PageVO;
import com.idea.spbmodeldemo.dao.VehicleModelPOMapper;
import com.idea.spbmodeldemo.entity.dto.VehicleModelAddDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleModelQueryDTO;
import com.idea.spbmodeldemo.entity.po.VehicleModelPO;
import com.idea.spbmodeldemo.entity.po.VehicleModelPOExample;
import com.idea.spbmodeldemo.entity.vo.VehicleModelBaseVO;
import com.idea.spbmodeldemo.entity.vo.VehicleModelVO;
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

@Service
public class VehicleModelServiceImpl implements IVehicleModelService {
	@Autowired
	private VehicleModelPOMapper mapper;
	
	@Autowired
	IVehicleSeriesService sService;
	
	@Autowired
	IVehicleBrandService brandService;
	
	
	@Override
	public String queryNameById(int id) {
		VehicleModelPOExample example = new VehicleModelPOExample();
		example.or().andIdEqualTo(id);
		List<VehicleModelPO> pos = mapper.selectByExample(example);
		if(pos!=null && pos.size()!=0) {
			String modelName = pos.get(0).getName();
			return modelName;
		}
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean addModel(VehicleModelAddDTO dto) throws Exception {
		VehicleModelPO po = new VehicleModelPO();
		BeanUtils.copyProperties(dto,po);			
//		int uid =Integer.parseInt(RequstUtil.getToken().getUserId());
		int uid = 1001; //测试时写死
		po.setCrtUid(uid);
		po.setUpdUid(uid);
		po.setCrtTime(new Date());
		po.setUpdTime(new Date());
		int num = mapper.insertSelective(po);
		//新增后更新car_code字段
		int id = po.getId();
		po.setCarCode(dto.getBrandId()+"/"+dto.getSeriesId()+"/"+id);
		int result = mapper.updateByPrimaryKeySelective(po);
		if (num>0 && result>0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public PageVO<List<VehicleModelVO>> queryVehicleModelByCondition(VehicleModelQueryDTO dto) {
		PageVO<List<VehicleModelVO>> pageVo = new PageVO<List<VehicleModelVO>>();
		List<VehicleModelVO> vos = new ArrayList<VehicleModelVO>();
		VehicleModelPOExample example = new VehicleModelPOExample();
		VehicleModelPOExample.Criteria  criteria = example.createCriteria();
		if(dto.getId()!=null && dto.getId()>0) {
			criteria.andIdEqualTo(dto.getId());
		}
		if(dto.getBrandId()!=null && dto.getBrandId()>0) {
			criteria.andCarCodeLike(dto.getBrandId()+"/%");
		}
		if(dto.getSeriesId()!=null && dto.getSeriesId()>0) {
			criteria.andCarCodeLike(dto.getBrandId()+"/"+dto.getSeriesId()+"/%");
		}
		if(!StringUtils.isEmpty(dto.getKeyword())) {
			criteria.andNameLike("%"+dto.getKeyword()+"%");
		}
		Page<VehicleModelPO> pageInfo = PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<VehicleModelPO> pos = mapper.selectByExample(example);
		if(pos!=null && pos.size()>0) {
			for(VehicleModelPO po:pos) {
				VehicleModelVO vo = new VehicleModelVO();
				BeanUtils.copyProperties(po, vo);
				//设置品牌名称；
				int brandId = Integer.valueOf(po.getCarCode().split("/")[0]);	
				int seriesId = Integer.valueOf(po.getCarCode().split("/")[1]);	
				vo.setBrandName(brandService.queryById(brandId).getName());
				//查询车系名称；
				vo.setSeriesName(sService.selectSeriesById(seriesId).getName());
//				//能源类型
//				vo.setEnergyType(EnergyType.getTypeByCode(po.getEnergyType()));
//				//查询车辆数量;
//				VehicleQueryApiDTO vehicleQueryDto = new VehicleQueryApiDTO();
//				vehicleQueryDto.setBrandId(brandId);
//				vehicleQueryDto.setSeriesId(seriesId);
//				vehicleQueryDto.setModelId(po.getId());
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
	public VehicleModelAddDTO queryById(Integer id) {
		VehicleModelAddDTO dto = new VehicleModelAddDTO();
		VehicleModelPO po = mapper.selectByPrimaryKey(id);
		if(po!=null) {
			BeanUtils.copyProperties(po, dto);
			dto.setBrandId(Integer.valueOf(po.getCarCode().split("/")[0]));
			dto.setSeriesId(Integer.valueOf(po.getCarCode().split("/")[1]));
			return dto;
		}
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean updateModel(VehicleModelAddDTO dto) throws Exception {
		VehicleModelPO po = new VehicleModelPO();
		BeanUtils.copyProperties(dto,po);
		po.setCarCode(dto.getBrandId()+"/"+dto.getSeriesId()+"/"+dto.getId());
		//当车辆油其他能源类型变更为电动时，油箱容量变为0
		if(dto.getEnergyType()== EnergyType.T_ELECTRIC.getCode()) {
			po.setFuelTankCap(0);
		}
		int uid = 1001; //测试时写死
//		if(!StringUtils.isEmpty(RequstUtil.getToken().getUserId())) {
//			int uid =Integer.valueOf(RequstUtil.getToken().getUserId());
//			po.setUpdUid(uid);
//		}
		po.setUpdTime(new Date());
		int result = mapper.updateByPrimaryKeySelective(po);
		//更新车辆车系名称	
        int vStatus = 0;
//  		if(!StringUtils.isEmpty(dto.getName())) {
//  			VehiclePOExample vExample = new VehiclePOExample();
//  			vExample.or().andCarCodeEqualTo(dto.getBrandId()+"/"+dto.getSeriesId()+"/"+dto.getId());
//  			VehiclePO vPo = new VehiclePO();
//  			vPo.setModelName(dto.getName());
//  			vStatus = vehicleMapper.updateByExampleSelective(vPo, vExample);
//  			if(result>0 && vStatus>0) {
//  				return true;
//  			}
//  		}
		if (result>0){
			return true;
		}else {
			return false;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean deleteModel(Integer id) {
		int result = mapper.deleteByPrimaryKey(id);
		if (result>0){
			return true;
		}else {
			return false;
		}
	}
	
	public List<VehicleModelBaseVO> queryListByCondition(VehicleModelQueryDTO dto) {		
		List<VehicleModelBaseVO> vos = new ArrayList<VehicleModelBaseVO>();
		VehicleModelPOExample example = new VehicleModelPOExample();
		VehicleModelPOExample.Criteria  criteria = example.createCriteria();
		if(dto.getBrandId()!=null && dto.getBrandId()>0) {
			criteria.andCarCodeLike(dto.getBrandId()+"/%");
		}
		if(dto.getSeriesId()!=null && dto.getSeriesId()>0) {
			criteria.andCarCodeLike(dto.getBrandId()+"/"+dto.getSeriesId()+"/%");
		}
		if(!StringUtils.isEmpty(dto.getKeyword())) {
			criteria.andNameLike("%"+dto.getKeyword()+"%");
		}
		List<VehicleModelPO> pos = mapper.selectByExample(example);
		if(pos!=null && pos.size()>0) {
			for(VehicleModelPO po:pos) {
				VehicleModelBaseVO vo = new VehicleModelBaseVO();
				BeanUtils.copyProperties(po, vo);
				vos.add(vo);
			}		
			return vos;
		}		
		return null;
	}

	@Override
	public Boolean exist(VehicleModelQueryDTO dto) {
		VehicleModelPOExample example = new VehicleModelPOExample();
		VehicleModelPOExample.Criteria  criteria = example.createCriteria();
		if(dto.getId()!=null && dto.getId()>0) {
			criteria.andIdEqualTo(dto.getId());
		}
		if(dto.getBrandId()!=null && dto.getBrandId()>0) {
			criteria.andCarCodeLike(dto.getBrandId()+"/%");
		}
		if(dto.getSeriesId()!=null && dto.getSeriesId()>0) {
			criteria.andCarCodeLike(dto.getBrandId()+"/"+dto.getSeriesId()+"/%");
		}
		if(!StringUtils.isEmpty(dto.getKeyword())) {
			criteria.andNameLike("%"+dto.getKeyword()+"%");
		}
		List<VehicleModelPO> pos = mapper.selectByExample(example);
		if(pos!=null && pos.size()>0) {
			return true;
		}
		return false;
	}
}
