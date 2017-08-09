package com.bicap.cloud.travelPath.service.impl;

import com.bicap.cloud.travelPath.entity.TravelPathData;
import com.bicap.cloud.travelPath.mapper.TravelPathMapper;
import com.bicap.cloud.travelPath.service.TravelPathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/7/21 0021.
 */
@Service
public class TravelPathServiceImpl implements TravelPathService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    TravelPathMapper travelPathMapper;
    public List getTravelPath(String taskId,String begin,String end,String score){
//        List all = new ArrayList();
        Map map = new HashMap();
        map.put("taskId",taskId);
        map.put("begin",begin);
        map.put("end",end);
        map.put("score",score);
        //得到首发
        List firstTravelPath = travelPathMapper.getFirstTravelPath(map);
        if(firstTravelPath.size()==0){
            return null;
        }
        TravelPathData t = (TravelPathData) firstTravelPath.get(0);
        List sourceName = new ArrayList();
        sourceName.add( t.getSourceName());
//        sourceName.add("四川日报");
//        List m = m(all, sourceName, map);
//        HashSet h = new HashSet(m);
//        m.clear();
//        m.add(h);
        HashSet all = new HashSet();
        HashSet m = m(all, sourceName, map);
        List list = new ArrayList();
        list.add(0,sourceName);
        list.add(1,m);
        System.out.println(list);
        return list;
    }


//    public HashSet m(HashSet all,List list,Map map){
//        for (int i = 0;i<list.size();i++){
//            Map<String,Object> m = new HashMap<>();
//            String sourceName = (String)list.get(i);
//            m.put("name",sourceName);
//            map.put("sourceName",sourceName);
//            List list1 = get(map);
//            List list2 = new ArrayList();
//            if(list1.size()>0){
//                for (int j = 0;j<list1.size();j++){
//                    Map<String,Object> m1 = new HashMap<>();
//                    String sourceName1 = (String)list1.get(j);
//                    m1.put("name",sourceName1);
//                    m1.put("children","");
//                    list2.add(m1);
//                }
//                m.put("children",list2);
//                all.add(m);
//                m(all,list1,map);
//            }
//        }
//        return all;
//    }

    //无chilrend的
    public HashSet m(HashSet all,List list,Map map){
        for (int i = 0;i<list.size();i++){
            Map<String,Object> m = new HashMap<>();
            String sourceName = (String)list.get(i);
            m.put("name",sourceName);
            map.put("sourceName",sourceName);
            List list1 = get(map);
            List list2 = new ArrayList();
            if(list1.size()>0){
                for (int j = 0;j<list1.size();j++){
                    Map<String,Object> m1 = new HashMap<>();
                    String sourceName1 = (String)list1.get(j);
                    m1.put("name",sourceName1);
                    list2.add(m1);
                }
                m.put("children",list2);
                all.add(m);
                m(all,list1,map);
            }
        }
        return all;
    }

//    public List m(List all,List list,Map map){
//            for (int i = 0;i<list.size();i++){
//                Map<String,Object> m = new HashMap<>();
//                String sourceName = (String)list.get(i);
//                m.put("name",sourceName);
//                map.put("sourceName",sourceName);
//                List list1 = get(map);
//                if(list1.size()>0){
//                    m.put("children",list1);
//                    all.add(m);
//                    m(all,list1,map);
//                }
//            }
//        return all;
//    }


//    public List m(List all,List list,Map map){
//        if(list.size()==0){
//            logger.info("没有人转发了");
//        }else{
//            for (int i = 0;i<list.size();i++){
//                Map<String,Object> m = new HashMap<>();
//                String sourceName = (String)list.get(i);
//                m.put("name",sourceName);
//                map.put("sourceName",sourceName);
//                List list1 = get(map);
//                if(list1.size()>0){
//                    m.put("children",list1);
//                    all.add(m);
//                    m(all,list1,map);
//                }
//            }
//        }
//        return all;
//    }



    public List get(Map map){
        List travelPath = travelPathMapper.getTravelPath(map);
        return travelPath;
    }
}








