package com.tedu.springboot2206.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    /**
     *
     * @param request   请求对象，封装着浏览器发送过来的所有内容
     * @param response  响应对象，封装着我们即将给浏览器回复的内容
     */
    @RequestMapping("/regUser")
    public void reg(HttpServletRequest request, HttpServletResponse response){
        System.out.println("开始处理注册！！！！！！！！！！！！！！");
        /*
            处理注册的大致过程
            1:获取用户在注册页面上输入的注册信息(通过请求对象获取浏览器提交的表单数据)
            2:处理注册
            3:设置响应对象，将处理结果回馈给浏览器
         */
    }
}