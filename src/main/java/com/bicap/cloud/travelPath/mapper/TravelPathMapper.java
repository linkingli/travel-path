package com.bicap.cloud.travelPath.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@Mapper
@Component
public interface TravelPathMapper {

   List getFirstTravelPath(Map param);
   List getTravelPath(Map param);

}
