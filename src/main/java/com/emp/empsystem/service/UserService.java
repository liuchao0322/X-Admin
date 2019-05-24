package com.emp.empsystem.service;

import com.emp.empsystem.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Liu
 * @create 2019/4/17 19:44
 */
public interface UserService {
    //根据用户名查询用户信息(集合)
    List<SysUser> findByUserName(String username);
    //根据用户名查询用户信息
    SysUser findUserByUsername(String username);
    //用户分页
    List<SysUser> findUserByPage(int currentPage, int PageSize);
    //获取用户总数
    int count();
    //获取所有用户总数
    int AllCount();
    //更新用户
    int updateUser(@Param("username") String username, @Param("password") String password, @Param("phonenumber") String phonenumber, @Param("email") String email, @Param("address") String address, @Param("id") int id);
    //修改密码
    int updatePwd(@Param("password") String password,@Param("id") int id);
    //删除用户
    int delUser(Integer[] arr);
    //查询用户当前状态
    String getUserState(int id);
    //用户停用
    int User_stop(String state,int id);
    //通过日期和名字查询用户
    List<SysUser> findUserByTimeAndName(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("username") String username);

    //通过日期和名字查询管理员
    List<SysUser> findManagerByTimeAndName(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("username") String username);

    //通过日期查询用户
    List<SysUser> findUserByTime(@Param("startTime") String startTime, @Param("endTime") String EndTime);

    //通过日期查询管理员
    List<SysUser> findManagerByTime(@Param("startTime") String startTime, @Param("endTime") String EndTime);

    //通过用户名查询用户
    List<SysUser> findUserByName(@Param("username") String username);

    //通过用户名查询管理员
    List<SysUser> findManagerByName(@Param("username") String username);
}
