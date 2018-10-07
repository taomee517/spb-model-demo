package com.idea.spbmodeldemo.dao;

import com.idea.spbmodeldemo.entity.po.VehicleSeriesPO;
import com.idea.spbmodeldemo.entity.po.VehicleSeriesPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleSeriesPOMapper {
    int countByExample(VehicleSeriesPOExample example);

    int deleteByExample(VehicleSeriesPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VehicleSeriesPO record);

    int insertSelective(VehicleSeriesPO record);

    List<VehicleSeriesPO> selectByExample(VehicleSeriesPOExample example);

    VehicleSeriesPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VehicleSeriesPO record, @Param("example") VehicleSeriesPOExample example);

    int updateByExample(@Param("record") VehicleSeriesPO record, @Param("example") VehicleSeriesPOExample example);

    int updateByPrimaryKeySelective(VehicleSeriesPO record);

    int updateByPrimaryKey(VehicleSeriesPO record);
}