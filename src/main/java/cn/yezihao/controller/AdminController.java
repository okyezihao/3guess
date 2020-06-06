package cn.yezihao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // 测试dataTables
    @RequestMapping("/datatable")
    public String datatable() {
        return "/dataTable";
    }

}