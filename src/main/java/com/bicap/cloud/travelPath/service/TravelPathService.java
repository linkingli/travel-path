package com.bicap.cloud.travelPath.service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
public interface TravelPathService {
    public List getTravelPath(String taskId, String begin, String end, String score);

}
