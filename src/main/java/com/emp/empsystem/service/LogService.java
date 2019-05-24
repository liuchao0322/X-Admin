package com.emp.empsystem.service;

import com.emp.empsystem.entity.SysLog;

import java.util.List;

/**
 * @Author Liu
 * @create 2019/5/7 8:44
 */
public interface LogService {
    //增加日志
    int addLog(SysLog sysLoglog);
    //查询日志
    List<SysLog> queryLog();
}
