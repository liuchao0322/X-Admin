package com.emp.empsystem.service.MyUserService;

import com.emp.empsystem.entity.SysPermission;
import com.emp.empsystem.entity.SysUser;
import com.emp.empsystem.service.PermissionService;
import com.emp.empsystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserService userService;
    @Resource
    private PermissionService permissionService;


    public UserDetails loadUserByUsername(String username) {
        SysUser user = userService.findUserByUsername(username);
        if (user != null) {
            System.out.println("user信息:" + user.getUsername());
            List<SysPermission> permissions = permissionService.findByAdminUserId(user.getId());
            for (SysPermission s : permissions) {
                System.out.println("权限:" + s.getName());
            }
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (SysPermission permission : permissions) {
                if (permission != null && permission.getName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
//            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//            String password = passwordEncoder.encode(user.getPassword());
//            System.out.println("加密密码："+password);
            if (user.getUser_state().equals("停用")) {
                logger.error(username + ":用户已被停用,无法进行登陆,请先启用用户！");
                throw new UsernameNotFoundException("该用户已被停用");
            }
            return new User(user.getUsername(), user.getPassword(),grantedAuthorities);

        } else {
            logger.error(username + "不存在");
            return null;
        }
    }

}
