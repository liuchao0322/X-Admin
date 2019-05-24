package com.emp.empsystem.dao;

import com.emp.empsystem.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Liu
 * @create 2019/5/7 8:39
 */
@Mapper
public interface LogMapper {
    //增加日志
    int addLog(SysLog sysLoglog);
    //查询日志
    List<SysLog> queryLog();
}
