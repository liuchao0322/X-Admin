package com.emp.empsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.emp.empsystem.entity.SysLog;
import com.emp.empsystem.entity.SysUser;
import com.emp.empsystem.service.LogService;
import com.emp.empsystem.service.UserService;
import com.emp.empsystem.util.BCryptPasswordEncoderTest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @Author Liu
 * @create 2019/4/17 19:19
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping("/member-list.html")
    public String member_list() {
        return "views/member/member-list";
    }

    @RequestMapping("/member-edit")
    public String member_edit(HttpServletRequest request, HttpSession session) {
        String cid = request.getParameter("id");
        int id = Integer.parseInt(cid);
        session.setAttribute("userid", id);
        return "views/member/member-edit";
    }

    @RequestMapping("/member-password")
    public String member_password(HttpServletRequest request, HttpSession session) {
        String cid = request.getParameter("id");
        int id = Integer.parseInt(cid);
        session.setAttribute("userid", id);
        return "views/member/member-password";
    }
    @RequestMapping("member-add")
    public String member_add(){
        return "views/member/member-add";
    }

    //注册
    @ResponseBody
    @RequestMapping("/reg")
    public void reg(HttpServletRequest request,HttpServletResponse response) throws IOException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String croleid = request.getParameter("roleid");
        int roleid = Integer.parseInt(croleid);
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        String md5Password = encoder.encode(password);
        String phonenumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        SysUser sysUser=new SysUser(username,md5Password,phonenumber,email,address);
        if (userService.findUserByUsername(sysUser.getUsername())==null){
            if (userService.UserReg(sysUser)>0){
                //获取ROLE
                String role = userService.QueryRoleNameByID(roleid);
                int i = userService.AddPeopleByNameAndRole(username, role);
                if (i > 0) {
                    PrintWriter out = response.getWriter();
                    out.write("ok");
                    out.flush();
                    out.close();
                }
            }

        }
    }

    //分页获取用户集合
    @ResponseBody
    @RequestMapping(value = "/findUser", produces = "text/html;charset=UTF-8")
    public String finUserByPage(@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) {
        JSONObject json = new JSONObject();
        int PageSize = 5;
        List<SysUser> ulist = userService.findUserByPage((currentPage - 1) * PageSize, PageSize);
        Integer count = userService.count();
        Integer countPage = count % PageSize == 0 ? count / PageSize : count / PageSize + 1;
        json.put("count", count);
        json.put("currentPage", currentPage);
        json.put("countPage", countPage);
        json.put("ulist", ulist);
        return json.toJSONString(json);
    }

    //获取用户总数
    @ResponseBody
    @RequestMapping("/getUserCount")
    public int getUserCount() {
        int count = userService.AllCount();
        if (count != 0) {
            return count;
        }
        return 0;
    }

    // 删除用户
    @ResponseBody
    @RequestMapping(value = "/delUser", method = RequestMethod.GET)
    @Transactional
    public void DelUser(@RequestParam(value = "arr") Integer[] arr, HttpServletResponse response, HttpSession session) throws IOException, IOException {
        PrintWriter out = response.getWriter();
        int result = userService.delUser(arr);
        if (result > 0) {
            String opera = "delete";
            String username = (String) session.getAttribute("user");
            for (int i : arr) {
                System.out.println(i);
                SysLog sysLog = new SysLog(username, i, opera);
                int log = logService.addLog(sysLog);
                if (log > 0) {
                    out.write("true");
                    out.flush();
                    out.close();
                }
            }
        }

    }

    //停用用户
    @ResponseBody
    @RequestMapping("/User_stop")
    @Transactional
    public void User_stop(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String cid = request.getParameter("id");
        int id = Integer.parseInt(cid);
        String userState = userService.getUserState(id);
        if (userState.equals("启用")) {
            String noState = "停用";
            int i = userService.User_stop(noState, id);
            if (i > 0) {
                String opera = "StopUsing";
                String username = (String) session.getAttribute("user");
                SysLog sysLog = new SysLog(username, id, opera);
                int log = logService.addLog(sysLog);
                if (log > 0) {
                    out.write("ok");
                    out.flush();
                    out.close();
                }
            }
        } else {
            String yesState = "启用";
            int i = userService.User_stop(yesState, id);
            if (i > 0) {
                String opera = "Using";
                String username = (String) session.getAttribute("user");
                SysLog sysLog = new SysLog(username, id, opera);
                int log = logService.addLog(sysLog);
                if (log > 0) {
                    out.write("ok");
                    out.flush();
                    out.close();
                }
            }
        }
    }

    //条件查询用户
    @ResponseBody
    @RequestMapping(value = "/sreachUser", method = RequestMethod.POST)
    public String sreachUser(HttpServletRequest request) {
        JSONObject json = new JSONObject();
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String username = request.getParameter("username");
        System.out.println("startTime:" + startTime + ",endTime:" + endTime + ",username:" + username);
        if (startTime == "" && endTime == "" && username != "") {
            List<SysUser> userList = userService.findByUserName(username);
            System.out.println("查找到的user" + userList);
            json.put("userList", userList);
        } else if (startTime != "" && endTime != "" && username != "") {
            List<SysUser> userList = userService.findUserByTimeAndName(startTime, endTime, username);
            System.out.println("查找到的用户列表:" + userList);
            json.put("userList", userList);
        } else {
            List<SysUser> userList = userService.findUserByTime(startTime, endTime);
            System.out.println("查找到的用户列表2:" + userList);
            json.put("userList", userList);
        }
        return json.toJSONString(json);
    }


    @ResponseBody
    @RequestMapping("updateUser")
    public void updateUser(SysUser user, HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String cid = request.getParameter("id");
        int id = Integer.parseInt(cid);
        String encodePwd = encoder.encode(user.getPassword());
        if (userService.updateUser(user.getUsername(), encodePwd, user.getPhonenumber(), user.getEmail(), user.getAddress(), id) > 0) {
            PrintWriter out = response.getWriter();
            out.write("ok");
            out.flush();
            out.close();
        }


    }

    @ResponseBody
    @RequestMapping("updatePwd")
    public void updatePwd(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String cid = request.getParameter("id");
        int id = Integer.parseInt(cid);
        String password = request.getParameter("newpass");
        String encodePwd = encoder.encode(password);
        if (userService.updatePwd(encodePwd, id) > 0) {
            PrintWriter out = response.getWriter();
            out.write("ok");
            out.flush();
            out.close();
        }

    }
}