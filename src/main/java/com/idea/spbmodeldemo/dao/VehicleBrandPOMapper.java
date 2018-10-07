package com.idea.spbmodeldemo.dao;

import com.idea.spbmodeldemo.entity.po.VehicleBrandPO;
import com.idea.spbmodeldemo.entity.po.VehicleBrandPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleBrandPOMapper {
    int countByExample(VehicleBrandPOExample example);

    int deleteByExample(VehicleBrandPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VehicleBrandPO record);

    int insertSelective(VehicleBrandPO record);

    List<VehicleBrandPO> selectByExample(VehicleBrandPOExample example);

    VehicleBrandPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VehicleBrandPO record, @Param("example") VehicleBrandPOExample example);

    int updateByExample(@Param("record") VehicleBrandPO record, @Param("example") VehicleBrandPOExample example);

    int updateByPrimaryKeySelective(VehicleBrandPO record);

    int updateByPrimaryKey(VehicleBrandPO record);
}