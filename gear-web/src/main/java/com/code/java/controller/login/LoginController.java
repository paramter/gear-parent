package com.code.java.controller.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户登陆controller层
 * Created by 刘长申 on 2017/7/11.
 */
@Controller
public class LoginController {

    private Logger logger  =  LoggerFactory.getLogger(LoginController.class);

    /**
     * 跳转登陆页面
     * @return
     */
    @RequestMapping(value="toLogin.do")
    public String toLogin(){
        return "index";
    }

    /**
     * 用户登陆
     * @param userId
     * @param password
     * @param rememberMe
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public String login(@RequestParam(value = "userId") String userId,
                        @RequestParam(value = "password") String password,
                        @RequestParam(value = "rememberMe") boolean rememberMe){
        logger.debug("当前登陆用户名:{},密码:{},rememberMe:{}" , userId , password, rememberMe);
        //定义令牌内容
        UsernamePasswordToken token = new UsernamePasswordToken(userId, password);
        token.setRememberMe(rememberMe);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return "redirect:home.do";
    }

    /**
     * 跳转主页面
     * @return
     */
    @RequestMapping(value="home.do")
    public String home(){
        logger.debug("跳转home页面");
        return "home/home";
    }

    /**
     * 登陆退出
     * @return
     */
    @RequestMapping(value = "logout.do")
    public String logout(){
        logger.debug("登陆退出。");
        Subject subject = SecurityUtils.getSubject();
        if(subject != null){
            subject.logout();
        }
        return "redirect:toLogin.do";
    }
}
