package cn.yezihao.controller;

import cn.yezihao.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    // 跳转到登录页面
    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    // 跳转到注册页面
    @GetMapping("/toRegister")
    public String toRegister() {
        return "register";
    }


    // 登录 , 获取 传来的 用户 , 密码
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        return userService.login(username, password, model);
    }

    // 用户注册
    @RequestMapping("/register")
    @ResponseBody
    public int register(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("email") String email,
                        HttpSession session) {
        return userService.register(username, password, email, session);
    }

    // 注销
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        Subject currentSubject = SecurityUtils.getSubject();

        System.out.println("用户注销=>[" + currentSubject.getSession() + "]");

        currentSubject.logout();
        session.removeAttribute("loginUser");
        return "login";
    }

    // 未授权页面
    @RequestMapping("/noAuth")
    public String unAuthorized() {
        return "noAuth";
    }

    // 判断用户名是否存在
    @PostMapping(value = "/user/isExist", produces = "application/json")
    @ResponseBody
    public boolean isExist(String username) {
//        System.out.println("用户 是否存在=> " + userService.isExistUsername(username));
        return userService.isExistUsername(username);
    }

    // 判断邮箱是否存在
    @PostMapping(value = "/user/isExistEmail", produces = "application/json")
    @ResponseBody
    public boolean isExistEmail(String email) {
//        System.out.println("邮箱 是否存在=> " + userService.isExistEmail(email));
        return userService.isExistEmail(email);
    }

    // 测试
    /*
    // 用户登录
    @RequestMapping("/login")
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {
        // User user = userService.checkUser(username, password);
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            // 登录成功 , 账户不为空 , 密码为123456
            session.setAttribute("loginUser",username);
            return "index";
        } else {
            // 登录失败
            model.addAttribute("msg","用户名或者密码错误!");
            return model;
        }
    }

    // 用户注册
    @RequestMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Model model, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            // 注册成功 , 设置 session 登录
            session.setAttribute("loginUser",username);
            return "index";
        } else {
            // 注册失败
            return "redirect:/toRegister";
        }
    }

    // 注销
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "index";
    }
    */

}
