package com.emp.empsystem.service.impl;

import com.emp.empsystem.dao.LogMapper;
import com.emp.empsystem.entity.SysLog;
import com.emp.empsystem.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Liu
 * @create 2019/5/7 8:44
 */
@Service
public class LogServiceImpl implements LogService {
    @Resource
    LogMapper logMapper;
    @Override
    public int addLog(SysLog sysLoglog) {
        return logMapper.addLog(sysLoglog);
    }

    @Override
    public List<SysLog> queryLog() {
        return logMapper.queryLog();
    }
}
