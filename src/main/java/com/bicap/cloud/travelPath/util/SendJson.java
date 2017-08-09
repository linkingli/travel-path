package com.bicap.cloud.travelPath.util;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
@Component
public class SendJson {
    RestTemplate restTemplate = new RestTemplate();

    public String sendPost(String param){
        MultiValueMap<String,String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("summary",param);
        return  restTemplate.postForObject("http://10.10.1.102:12500/summary",requestEntity,String.class);
    }
}
