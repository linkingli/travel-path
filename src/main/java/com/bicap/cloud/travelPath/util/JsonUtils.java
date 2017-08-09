package com.bicap.cloud.travelPath.util;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class JsonUtils {
    private JsonUtils(){}

    @SuppressWarnings("unchecked")
    public static Map<String,Object> json2Map(String json){
        return JSON.parseObject(json, Map.class);
    }

    public static String obj2JsonString(Object obj){
        return JSON.toJSONString(obj);
    }

}
