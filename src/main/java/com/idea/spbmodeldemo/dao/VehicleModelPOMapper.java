package com.idea.spbmodeldemo.dao;

import com.idea.spbmodeldemo.entity.po.VehicleModelPO;
import com.idea.spbmodeldemo.entity.po.VehicleModelPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleModelPOMapper {
    int countByExample(VehicleModelPOExample example);

    int deleteByExample(VehicleModelPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VehicleModelPO record);

    int insertSelective(VehicleModelPO record);

    List<VehicleModelPO> selectByExample(VehicleModelPOExample example);

    VehicleModelPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VehicleModelPO record, @Param("example") VehicleModelPOExample example);

    int updateByExample(@Param("record") VehicleModelPO record, @Param("example") VehicleModelPOExample example);

    int updateByPrimaryKeySelective(VehicleModelPO record);

    int updateByPrimaryKey(VehicleModelPO record);
}