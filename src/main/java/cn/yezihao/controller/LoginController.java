package cn.yezihao.controller;

import cn.yezihao.entity.User;
import cn.yezihao.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

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
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 加密相同的方法 , 校验密码
        ByteSource salt = ByteSource.Util.bytes(username);
        String md5 = new SimpleHash("md5", password, salt, 1024).toHex();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, md5);
        try {
            // 执行登录方法 , 如果无异常则
            subject.login(token);

            System.out.println("用户登录=>[" + username + "]");

            // 添加session
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            session.setAttribute("loginUser", token.getUsername());
            return "index";
        } catch (UnknownAccountException e) { // 用户名不存在
            model.addAttribute("msg", "用户名错误！");
            return "login";
        } catch (IncorrectCredentialsException e) { // 密码不存在
            model.addAttribute("msg2", "密码错误!");
            return "login";
        }

    }

    // 用户注册
    @RequestMapping("/register")
    @ResponseBody
    public int register(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("email") String email,
                        HttpSession session) {
        // 将密码进行MD5加盐加密并存到数据库中
        ByteSource salt = ByteSource.Util.bytes(username);
        /*
         * MD5加密：
         * 使用SimpleHash类对原始密码进行加密。
         * 第一个参数代表使用MD5方式加密
         * 第二个参数为原始密码
         * 第三个参数为盐值，即userId
         * 第四个参数为加密次数
         * 最后用toHex()方法将加密后的密码转成String
         * */
        // 转为密文 , 参数为加密方式 , 明文密码 , 盐值 , 迭代次数
        String md5 = new SimpleHash("md5", password, salt, 1024).toHex();
        User user = new User();
        user.setUsername(username);
        // user.setPassword(md5.toString()); // 若没有用.toHex()则需要toString()
        user.setPassword(md5); // 密码通过密文存储
        // 设置邮箱
        user.setEmail(email);
        // 设置创建日期
        user.setCdate(new Date());
        // 判断用户是否存在
        if (userService.selectUserByName(username) == null && userService.selectUserByEmail(email) == null) {
            // 保存到数据库中
            userService.addUser(user);
            // 注册成功 , 设置 session 登录
            session.setAttribute("loginUser", username);

            System.out.println("用户注册=>[" + username + "]");

            return 200;
//            return "index";
        } else {
            // 注册失败
            return 404;
//            return "redirect:/toRegister";
        }
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
