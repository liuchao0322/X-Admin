package com.emp.empsystem.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author Liu
 * @create 2019/4/4 8:28
 */
@Controller
public class LoginController {
    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @ResponseBody
    @RequestMapping("/whoim")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public Object whoIm(HttpSession session) {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @RequestMapping(value = "/loginSecurity")
    public String index() {
        return "login";
    }

    @RequestMapping("/welcome.html")
    public String welcome() {
        return "views/welcome/welcome";
    }

    @RequestMapping("/index")
    public String success(HttpSession session){

        Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=((UserDetails) o).getUsername();
        session.setAttribute("user", username);
        return "views/index";
    }





}