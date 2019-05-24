package com.emp.empsystem.service;

import com.emp.empsystem.entity.SysPermission;

import java.util.List;

/**
 * @Author Liu
 * @create 2019/4/23 8:49
 */
public interface PermissionService {
    List<SysPermission> findByAdminUserId(int userId);
}
