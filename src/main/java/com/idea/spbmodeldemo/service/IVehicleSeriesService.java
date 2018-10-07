package com.idea.spbmodeldemo.service;


import com.idea.spbmodeldemo.common.PageVO;
import com.idea.spbmodeldemo.entity.dto.VehicleSeriesAddDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleSeriesQueryAllDTO;
import com.idea.spbmodeldemo.entity.dto.VehicleSeriesQueryListDTO;
import com.idea.spbmodeldemo.entity.vo.VehicleSeriesBaseVO;
import com.idea.spbmodeldemo.entity.vo.VehicleSeriesDetailVO;
import com.idea.spbmodeldemo.entity.vo.VehicleSeriesListVO;

import java.util.List;

/**
 * @项目：fzk-app-monitor
 * @创建人： zhangxia
 * @创建时间： 2018/8/28
 * @描述：车辆的车系 service
 * @version：1.0
 */
public interface IVehicleSeriesService {

    /**
     * @Author: zhangxia
     * @methodName:addSeries
     * @Description:添加车辆的车系信息
     * @Date: 13:54 2018/8/28
     * @Param: [dto]
     * @return: java.lang.Boolean
     * @version: 1.0
     * @throws Exception 
     */
    Boolean addSeries(VehicleSeriesAddDTO dto) throws Exception;

    /**
     * @Author: zhangxia
     * @methodName:updateSeries
     * @Description:编辑更新车系信息
     * @Date: 14:22 2018/8/28
     * @Param: [dto]
     * @return: java.lang.Boolean
     * @version: 1.0
     * @throws Exception 
     */
    Boolean updateSeries(VehicleSeriesAddDTO dto) throws Exception;

    /**
     * @Author: zhangxia
     * @methodName:delete
     * @Description:物理删除车系数据(物理删除，注意：有车辆或车型配置引用的车系不能删除)
     * @Date: 19:32 2018/8/28
     * @Param: [id]
     * @return: java.lang.Boolean
     * @version: 1.0
     */
    Boolean deleteSeries(Integer id);

    /**
     * @Author: zhangxia
     * @methodName:selectSeriesById
     * @Description:通过车系id获取车系的基本信息
     * @Date: 15:01 2018/8/28
     * @Param: [id]
     * @return: com.fzk.terminal.api.vo.VehicleSeriesDetailVO
     * @version: 1.0
     */
    VehicleSeriesDetailVO selectSeriesById(Integer id);

    /**
     * @Author: zhangxia
     * @methodName:selectSeriesByPage
     * @Description:分页查询车辆的车系列表
     * @Date: 14:03 2018/8/28
     * @Param: [dto]
     * @return: java.util.List<com.fzk.terminal.api.vo.VehicleSeriesListVO>
     * @version: 1.0
     */
    PageVO<List<VehicleSeriesListVO>> selectSeriesByPage(VehicleSeriesQueryListDTO dto);

    /**
     * @Author: zhangxia
     * @methodName:selectSeriesAll
     * @Description:根据条件查询所有车辆的车系信息
     * @Date: 14:05 2018/8/28
     * @Param: []
     * @return: java.util.List<com.fzk.terminal.api.vo.VehicleSeriesPO>
     * @version: 1.0
     */
    List<VehicleSeriesBaseVO> selectSeriesAll(VehicleSeriesQueryAllDTO dto);


}
