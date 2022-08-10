package com.tedu.springboot2206.controller;

import com.tedu.springboot2206.entity.User;
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
        //1获取注册页面上的表单信息
        /*
            HttpServletRequest的重要方法:
            String getParameter(String name)
            获取浏览器传递过来的某个参数的值
            这里的传入的是参数名，对应的是页面表单输入框的名字(name属性对应的值)
         */
        String username = request.getParameter("username");//获取用户名
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");
        String ageStr = request.getParameter("age");
        System.out.println(username+","+password+","+nickname+","+ageStr);


        int age = Integer.parseInt(ageStr);//将年龄转换为int值
        /*
            2
            将该注册用户信息以User对象形式表示并序列化到文件中保存

            将来所有的保存用户信息的文件都统一放在users目录下，并且每个保存用户的文件的名字格式:用户名.obj

         */
        User user = new User(username,password,nickname,age);


    }
}
