package com.idea.spbmodeldemo.dao;

import com.idea.spbmodeldemo.entity.po.VehicleBrandAliasPO;
import com.idea.spbmodeldemo.entity.po.VehicleBrandAliasPOExample;
import com.idea.spbmodeldemo.entity.vo.VehicleBrandAliasVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VehicleBrandAliasPOMapper {
    int countByExample(VehicleBrandAliasPOExample example);

    int deleteByExample(VehicleBrandAliasPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VehicleBrandAliasPO record);

    int insertSelective(VehicleBrandAliasPO record);

    List<VehicleBrandAliasPO> selectByExample(VehicleBrandAliasPOExample example);

    List<VehicleBrandAliasVO> selectByAliasExample(VehicleBrandAliasPOExample example);

    VehicleBrandAliasPO selectByPrimaryKey(Integer id);

    VehicleBrandAliasVO selectByAliasPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VehicleBrandAliasPO record, @Param("example") VehicleBrandAliasPOExample example);

    int updateByExample(@Param("record") VehicleBrandAliasPO record, @Param("example") VehicleBrandAliasPOExample example);

    int updateByPrimaryKeySelective(VehicleBrandAliasPO record);

    int updateByPrimaryKey(VehicleBrandAliasPO record);
}