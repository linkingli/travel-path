package com.bicap.cloud.travelPath.controller;

import com.bicap.cloud.travelPath.service.TravelPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@RestController
@RequestMapping("/travelPath")
public class TravelPathController {
    @Autowired
    TravelPathService travelPathService;

    @RequestMapping(value="/list",method = RequestMethod.POST)
    public List getTop8ActiveIntUser(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
        String taskId = request.getParameter("taskId");
        String begin = request.getParameter("begin");
        String end = request.getParameter("end");
        String score = request.getParameter("score");
//        String taskId = "9";
//        String begin = "2016-06-14";
//        String end = "2017-07-18";
//        String score = null;
        return travelPathService.getTravelPath(taskId,begin,end,score);
    }

//    @RequestMapping("/list")
//    public List getTop8ActiveIntUser(HttpServletRequest request, HttpServletResponse response){
//        String taskId = "9";
//        String begin = "2016-06-14";
//        String end = "2017-07-18";
//        String score = null;
//        return travelPathService.getTravelPath(taskId,begin,end,score);
//}
}

















