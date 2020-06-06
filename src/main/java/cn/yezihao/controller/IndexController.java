package cn.yezihao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // 跳转到 首页
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    // 跳转到 管理员页面
    @GetMapping("/admin/toAdmin")
    public String toAdmin() {
        return "admin/admin";
    }

    // 跳转到 管理用户页面
    @GetMapping("/admin/toUser")
    public String toUser() {
        return "admin/user";
    }

    // 跳转到 反馈页面
    @GetMapping("/toFeedback")
    public String toFeedback() {
        return "user/feedback";
    }

    // 跳转到 全局搜索
    @GetMapping("/searchAll")
    public String searchAll() {
        return "search";
    }

}
