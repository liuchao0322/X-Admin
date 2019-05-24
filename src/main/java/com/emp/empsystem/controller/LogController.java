package com.emp.empsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.emp.empsystem.entity.SysLog;
import com.emp.empsystem.service.LogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Liu
 * @create 2019/5/7 8:43
 */
@Controller
public class LogController {
    @Resource
    LogService logService;

    @RequestMapping("/log.html")
    public String log() {
        return "views/log";
    }


    @RequestMapping("/addlog")
    public int addlog(SysLog sysLog) {
        return logService.addLog(sysLog);
    }

    @ResponseBody
    @RequestMapping("/queryLog")
    public String queryLog() {
        JSONObject json = new JSONObject();
        List<SysLog> sysLogList = logService.queryLog();
        System.out.println(sysLogList);
        //前台通过key值获得对应的value值
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", 1000);
        json.put("data", sysLogList);
        return json.toJSONString();

    }

}
