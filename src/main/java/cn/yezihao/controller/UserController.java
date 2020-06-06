package cn.yezihao.controller;

import cn.yezihao.entity.User;
import cn.yezihao.service.UserService;
import cn.yezihao.util.LayuiTypeJson;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    // 返回 admin 用户列表
    @GetMapping("/admin/userList")
    @ResponseBody
    public LayuiTypeJson<User> findAllGuess() {
        List<User> list = userService.findAllUser();
        LayuiTypeJson<User> json = new LayuiTypeJson<>();
        json.setCount(list.size());
        json.setData(list);
        return json;
    }

    // 弹出层 跳转 新增用户表单
    @GetMapping("/admin/toUAddForm")
    public String toUAddForm() {
        return "admin/UserAddForm";
    }

    // 弹出层 提交 新增用户表单
    @PostMapping("/admin/addUser")
    @ResponseBody
    public int addUser(User user) {
        // 将密码进行MD5 加盐加密
        ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        // 转为密文 ( 加密方式 , 明文密码 , 盐值 , 迭代次数 )
        String md5 = new SimpleHash("md5", user.getPassword(), salt, 1024).toHex();
        user.setPassword(md5);
        // 判断数据库中是否存在相同用户名 , 相同邮箱
        if (userService.selectUserByName(user.getUsername()) == null
                && userService.selectUserByEmail(user.getEmail()) == null) {

            System.out.println("admin新增用户信息=>[" + user + "]");

            // 保存到数据库中
            userService.addUser(user);
            return 200;
        }
        return 404;
    }

    // 弹出层 跳转 用户修改表单
    @RequestMapping("/admin/toUUpdateForm/{id}")
    public String toUpdateUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("QUser", user);
        return "admin/UserUpdateForm";
    }

    // 弹出层 提交 修改用户表单
    @PostMapping("/admin/updateUser")
    @ResponseBody
    public int updateUser(User user) {
        // 修改密码后再加密
        /*ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        String md5 = new SimpleHash("md5", user.getPassword(), salt, 1024).toHex();
        user.setPassword(md5);*/
        User user1 = userService.selectUserByEmail(user.getEmail());
//        System.out.println("数据库存在邮箱=>" + user1.getEmail());
//        System.out.println("输入邮箱=>" + user.getEmail());
        // 判断邮箱是否相同 , 相同修改失败
        if (user.getEmail() != user1.getEmail() || user1.getEmail()==null) {
            userService.updateUser(user);

            System.out.println("admin修改用户信息=>[" + user.getUsername() + "]");

            return 200;
        }
        return 404;
    }

    // 删除 行数据
    @PostMapping("/admin/delUser/{id}")
    @ResponseBody
    public String delUser(@PathVariable("id") Integer id) {
        System.out.println("删除一个用户,id=>[" + id + "]");
        userService.deleteUser(id);
        return JSON.toJSONString(id);
    }

    // 删除 多行数据 返回json字符串
    @PostMapping("/admin/delManyUser")
    @ResponseBody
    public String delManyUser(@RequestParam("id[]") String[] id) {
        for (int i = 0; i < id.length; i++) {
            String n = id[i];
            int t = Integer.parseInt(n);
            System.out.println("用户删除,id=>[" + t + "]");
            userService.deleteUser(t);
        }

        System.out.println("删除用户数组,id=>[" + JSON.toJSONString(id) + "]");

        return JSON.toJSONString(id);
    }

    // 用户 模糊查询
    @PostMapping("/admin/selectU")
    @ResponseBody
    public LayuiTypeJson<User> selectBySearch(@RequestParam("search") String search) {
        List<User> users = userService.selectUserBySearch(search);
        LayuiTypeJson<User> json = new LayuiTypeJson<>();
        json.setCount(users.size());
        json.setData(users);
//        System.out.println("搜索谜语数据列表=>" + users);
        return json;
    }

    // 跳转到 用户个人资料页面 , 信息回显
    @RequestMapping("/user/toUserPage/{username}")
    public String toUserPage(Model model, @PathVariable("username") String username) {
        User user = userService.selectUserByName(username);
        model.addAttribute("QUser", user);
        return "user/user";
    }

    // 提交 修改用户表单
    @PostMapping("/admin/iUpdateUser")
    @ResponseBody
    public int iUpdateUser(User user) {
        // 修改密码后再加密
        ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        String md5 = new SimpleHash("md5", user.getPassword(), salt, 1024).toHex();
        user.setPassword(md5);
        // 判断邮箱是否相同 , 相同修改失败
        User findUserEmail = userService.selectUserByEmail(user.getEmail());
        User findUsername = userService.selectUserByName(user.getUsername());
        if (findUsername.getEmail() != user.getEmail() || findUserEmail.getEmail() == null) {
            userService.updateUser(user);

            System.out.println("用户修改个人资料=>[" + user.getUsername() + "]");

//            System.out.println("数据库存在邮箱"+findUserEmail.getEmail());
//            System.out.println("输入邮箱"+user.getEmail());
            return 200;
        }
        return 404;
    }

}
