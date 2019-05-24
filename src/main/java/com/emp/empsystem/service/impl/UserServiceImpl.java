package com.emp.empsystem.service.impl;

import com.emp.empsystem.dao.UserMapper;
import com.emp.empsystem.entity.SysUser;
import com.emp.empsystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Liu
 * @create 2019/4/17 19:46
 */
@Service
public class UserServiceImpl extends Thread implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public List<SysUser> findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public SysUser findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public List<SysUser> findUserByPage(int currentPage, int PageSize) {
        return userMapper.findUserByPage(currentPage, PageSize);
    }

    @Override
    public int count() {
        return userMapper.count();
    }

    @Override
    public int AllCount() {
        return userMapper.AllCount();
    }

    @Override
    public int updateUser(String username, String password, String phonenumber, String email, String address, int id) {
        return userMapper.updateUser(username, password, phonenumber, email, address, id);
    }

    @Override
    public int updatePwd(String password, int id) {
        return userMapper.updatePwd(password, id);
    }

    @Override
    public int delUser(Integer[] arr) {
        return userMapper.delUser(arr);
    }

    @Override
    public String getUserState(int id) {
        return userMapper.getUserState(id);
    }

    @Override
    public int User_stop(String state, int id) {
        return userMapper.User_stop(state, id);
    }

    @Override
    public List<SysUser> findUserByTimeAndName(String startTime, String endTime, String username) {
        return userMapper.findUserByTimeAndName(startTime, endTime, username);
    }

    @Override
    public List<SysUser> findManagerByTimeAndName(String startTime, String endTime, String username) {
        return userMapper.findManagerByTimeAndName(startTime, endTime, username);
    }

    @Override
    public List<SysUser> findUserByTime(String startTime, String EndTime) {
        return userMapper.findUserByTime(startTime, EndTime);
    }

    @Override
    public List<SysUser> findManagerByTime(String startTime, String EndTime) {
        return userMapper.findManagerByTime(startTime, EndTime);
    }

    @Override
    public List<SysUser> findUserByName(String username) {

        return userMapper.findUserByName(username);
    }

    @Override
    public List<SysUser> findManagerByName(String username) {
        return userMapper.findManagerByName(username);
    }


}
