package com.emp.empsystem.dao;

import com.emp.empsystem.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author Liu
 * @create 2019/4/16 9:14
 */
@Mapper
public interface PermissionMapper {
    List<SysPermission> findByAdminUserId(int userId);
}
