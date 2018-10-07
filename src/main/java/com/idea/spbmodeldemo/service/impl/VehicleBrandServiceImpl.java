package com.idea.spbmodeldemo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.idea.spbmodeldemo.common.PageVO;
import com.idea.spbmodeldemo.dao.VehicleBrandPOMapper;
import com.idea.spbmodeldemo.dao.VehicleModelPOMapper;
import com.idea.spbmodeldemo.dao.VehicleSeriesPOMapper;
import com.idea.spbmodeldemo.entity.dto.VehicleBrandAddDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleBrandQueryApiDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleModelQueryDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleSeriesQueryAllDTO;
import com.idea.spbmodeldemo.entity.po.*;
import com.idea.spbmodeldemo.entity.vo.*;
import com.idea.spbmodeldemo.service.IVehicleBrandService;
import com.idea.spbmodeldemo.service.IVehicleModelService;
import com.idea.spbmodeldemo.service.IVehicleSeriesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


@Service
public class VehicleBrandServiceImpl implements IVehicleBrandService {

	/**
	 * 车辆品牌
	 */
	@Autowired
	private VehicleBrandPOMapper mapper;

	/**
	 * 车型配置
	 */
	@Autowired
	private VehicleModelPOMapper modelPOMapper;
	
	@Autowired
	private VehicleSeriesPOMapper seriesPOMapper;
	
	/**
	 * 车系服务层接口
	 */
	@Autowired
	private IVehicleSeriesService sService;
	
	/**
	 * 车型服务层接口
	 */
	@Autowired
	private IVehicleModelService mService;
	



	@Override
	public String queryNameById(int id) {
		return mapper.selectByPrimaryKey(id).getName();
	}

	/**
	 * @Author: zhangxia
	 * @methodName:addBrand
	 * @Description:添加车牌信息
	 * @Date: 16:40 2018/8/25
	 * @Param: [dto]
	 * @return: java.lang.Boolean
	 * @version: 1.0
	 * @throws Exception 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean addBrand(VehicleBrandAddDTO dto) throws Exception {
		VehicleBrandPO po = new VehicleBrandPO();
		BeanUtils.copyProperties(dto,po);
		int uid = 1001; //测试进写死
		po.setCrtTime(new Date());
		po.setCrtUid(uid);
		po.setUpdTime(new Date());
		po.setUpdUid(uid);
		int num = mapper.insertSelective(po);
		if (num>0){
			return true;
		}
		return false;
	}


	/**
	 * @Author: zhangxia
	 * @methodName:queryBrandByCondition
	 * @Description:根据条件查询车牌车型信息
	 * @Date: 17:18 2018/8/25
	 * @Param: [dto]
	 * @return: com.fzk.terminal.api.vo.VehicleBrandListVO
	 * @version: 1.0
	 */
	@Override
	public PageVO<List<VehicleBrandListVO>> queryBrandByPage(VehicleBrandQueryApiDTO dto) {
		PageVO<List<VehicleBrandListVO>> pageVo = new PageVO<List<VehicleBrandListVO>>();
		VehicleBrandPOExample example = new VehicleBrandPOExample();
		if(!StringUtils.isEmpty(dto.getKeyword())) {
			example.or().andNameLike("%"+dto.getKeyword()+"%");
		}		
		Page<VehicleBrandPO> pageInfo = PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		List<VehicleBrandPO> pos = mapper.selectByExample(example);
		List<VehicleBrandListVO> vos = new ArrayList<VehicleBrandListVO>();
		if(pos!=null && pos.size()>0) {
			for(VehicleBrandPO po:pos) {
				VehicleBrandListVO vo = new VehicleBrandListVO();
				BeanUtils.copyProperties(po, vo);
				//设置旗下车系总量
				int brandId = po.getId();
				VehicleSeriesQueryAllDTO seriesQueryDto = new VehicleSeriesQueryAllDTO();
				seriesQueryDto.setBrandId(brandId);
				List<VehicleSeriesBaseVO> svos = sService.selectSeriesAll(seriesQueryDto);
				if(svos!=null && svos.size()>0) {
					vo.setSeriesNum(svos.size());
				}else {
					vo.setSeriesNum(0);
				}
				//设置旗下车型总量
				VehicleModelQueryDTO modelQueryDto = new VehicleModelQueryDTO();
				modelQueryDto.setBrandId(brandId);
				List<VehicleModelBaseVO> mvos = mService.queryListByCondition(modelQueryDto);
				if(mvos!=null && mvos.size()>0) {
					vo.setModelNum(mvos.size());
				}else {
					vo.setModelNum(0);
				}				
				//设置旗下汽车总量,待完善;
//				VehicleQueryApiDTO vehicleQueryDto = new VehicleQueryApiDTO();
//				vehicleQueryDto.setBrandId(brandId);
//				int count = vService.countByDTO(vehicleQueryDto);
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
	public List<VehicleBrandBaseVO> queryBrandByDto(VehicleBrandQueryApiDTO dto) {
		VehicleBrandPOExample example = new VehicleBrandPOExample();
		if(!StringUtils.isEmpty(dto.getKeyword())) {
			example.or().andNameEqualTo(dto.getKeyword());
		}		
		List<VehicleBrandPO> pos = mapper.selectByExample(example);
		List<VehicleBrandBaseVO> vos = new ArrayList<VehicleBrandBaseVO>();
		if(pos!=null && pos.size()>0) {
			for(VehicleBrandPO po:pos) {
				VehicleBrandBaseVO vo = new VehicleBrandBaseVO();
				BeanUtils.copyProperties(po, vo);
				vos.add(vo);
			}
			return vos;
		}
		return null;
	}

	@Override
	public VehicleBrandAddDTO queryById(Integer id) {
		VehicleBrandPOExample example = new VehicleBrandPOExample();
		example.or().andIdEqualTo(id);
		VehicleBrandPO po = mapper.selectByPrimaryKey(id);
		if(po!=null) {
			VehicleBrandAddDTO dto = new VehicleBrandAddDTO();
			BeanUtils.copyProperties(po, dto);
			return dto;
		}
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean updateBrandInfo(VehicleBrandAddDTO dto) throws Exception {
		int vStatus = 0;
		VehicleBrandPO po = new VehicleBrandPO();
		BeanUtils.copyProperties(dto, po);
		int uid = 1001; //测试时写死
//		if(!StringUtils.isEmpty(RequstUtil.getToken().getUserId())) {
//			int uid =Integer.valueOf(RequstUtil.getToken().getUserId());
//			po.setUpdUid(uid);
//		}
		po.setUpdTime(new Date());		
		int result = mapper.updateByPrimaryKeySelective(po);		
		//更新车辆品牌名称		
//		if(!StringUtils.isEmpty(dto.getName())) {
//			VehiclePOExample vExample = new VehiclePOExample();
//			vExample.or().andCarCodeLike(dto.getId()+"/%");
//			VehiclePO vPo = new VehiclePO();
//			vPo.setBrandName(dto.getName());
//			vStatus = vehicleMapper.updateByExampleSelective(vPo, vExample);
//			if(result>0 && vStatus>0) {
//				return true;
//			}
//		}
		if(result>0) {
			return true;
		}		
		return false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public Boolean delete(Integer id) {
		int result = mapper.deleteByPrimaryKey(id);
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<VehicleBrandBaseVO> queryAll() {
		List<VehicleBrandBaseVO> vos = new ArrayList<VehicleBrandBaseVO>();
		List<VehicleBrandPO> pos = mapper.selectByExample(new VehicleBrandPOExample());
		if(!CollectionUtils.isEmpty(pos)) {
			for(VehicleBrandPO po: pos) {
				VehicleBrandBaseVO vo = new VehicleBrandBaseVO();
				BeanUtils.copyProperties(po, vo);
				vos.add(vo);
			}			
			return vos;
		}
		return null;
	}

	@Override
	public List<VehicleBrandTreeVO> selectModelTree() {
		List<VehicleBrandTreeVO> vos = new ArrayList<>();
		List<VehicleBrandPO> pos = mapper.selectByExample(new VehicleBrandPOExample());
		if(!CollectionUtils.isEmpty(pos)) {
			for(VehicleBrandPO po: pos) {
				VehicleBrandTreeVO vo = new VehicleBrandTreeVO();
				BeanUtils.copyProperties(po, vo);
				List<VehicleSeriesTreeVO> seriesTree = new ArrayList<>();
				VehicleSeriesPOExample example = new VehicleSeriesPOExample();
				example.or().andCarCodeLike(po.getId()+"/%");
				List<VehicleSeriesPO> seriesPos = seriesPOMapper.selectByExample(example);
				if(!CollectionUtils.isEmpty(seriesPos)) {
					for(VehicleSeriesPO seriesPo:seriesPos) {
						VehicleSeriesTreeVO seriesVo = new VehicleSeriesTreeVO();
						BeanUtils.copyProperties(seriesPo, seriesVo);
						List<VehicleModelBaseVO> modelVos = new ArrayList<>();
						VehicleModelPOExample modelExample = new VehicleModelPOExample();
						modelExample.or().andCarCodeLike(po.getId()+"/"+seriesPo.getId()+"/%");
						List<VehicleModelPO> modelPos = modelPOMapper.selectByExample(modelExample);
						if(!CollectionUtils.isEmpty(modelPos)) {
							for(VehicleModelPO modelPo:modelPos) {
								VehicleModelBaseVO modelVo = new VehicleModelBaseVO();
								BeanUtils.copyProperties(modelPo, modelVo);
								modelVos.add(modelVo);
							}
							seriesVo.setChildren(modelVos);
						}
						seriesTree.add(seriesVo);
					}
					vo.setChildren(seriesTree);
				}				
				vos.add(vo);
			}			
			return vos;
		}
		return null;
	}
}
