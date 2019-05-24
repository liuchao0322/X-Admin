package com.emp.empsystem.service.impl;

import com.emp.empsystem.dao.PermissionMapper;
import com.emp.empsystem.entity.SysPermission;
import com.emp.empsystem.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Liu
 * @create 2019/4/23 8:51
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;
    @Override
    public List<SysPermission> findByAdminUserId(int userId) {
        return permissionMapper.findByAdminUserId(userId);
    }
}
