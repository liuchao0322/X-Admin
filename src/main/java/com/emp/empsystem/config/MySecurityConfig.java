package com.emp.empsystem.config;

import com.emp.empsystem.service.MyUserService.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @Author Liu
 * @create 2019/4/12 17:12
 */
@Configuration
@EnableWebSecurity // 注解开启Spring Security的功能
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启spring security注解功能
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private MyUserService myUserService;
    @Resource
    //自定义登陆失败跳转的页面
    private SecurityAuthenticationFailHandler securityAuthenticationFailHandler;
    @Resource
    //自定义登陆成功跳转的页面
    private SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler;

    //自定义登陆拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.csrf().disable() //禁用csrf
                .formLogin().loginPage("/loginSecurity").loginProcessingUrl("/loginSecurity") //开启自定义登陆页面action方法
                .successHandler(securityAuthenticationSuccessHandler)//登陆成功
                .failureHandler(securityAuthenticationFailHandler)//登陆失败
                .permitAll()//以上允许访问
                .and()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/loginSecurity", "/logout").permitAll()//登陆页面和退出页面
                .antMatchers("/assets/**", "/favicon.ico").permitAll()//静态资源处理
                .anyRequest()
                .authenticated();


    }

    /**
     * 设置密码加密方式
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //自定义授权方式
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserService).passwordEncoder(passwordEncoder());
    }
}
