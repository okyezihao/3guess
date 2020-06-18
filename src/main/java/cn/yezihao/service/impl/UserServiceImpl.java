package cn.yezihao.service.impl;

import cn.yezihao.dao.UserDao;
import cn.yezihao.entity.User;
import cn.yezihao.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    // 新增 用户
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    // 删除 用户
    public int deleteUser(Integer id) {
        return userDao.deleteUser(id);
    }

    // 修改用户资料
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    // 查询 所有用户
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    // 查询 用户 ById
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    // 查询 用户 ByName
    public User selectUserByName(String username) {
        return userDao.selectUserByName(username);
    }

    // 查询 用户 ByEmail
    public User selectUserByEmail(String email) {
        return userDao.selectUserByEmail(email);
    }

    // 模糊查询
    public List<User> selectUserBySearch(String search) {
        return userDao.selectUserBySearch(search);
    }

    // 判断用户名是否存在
    public boolean isExistUsername(String username) {
        // 用户名不等空 , 返回 true 存在
        if (selectUserByName(username) != null) {
            // true 不存在
            return true;
        } else {
            // false 存在
            return false;
        }
    }

    // 判断邮箱是否存在
    public boolean isExistEmail(String email) {
        // 用户名不等空 , 返回 true 存在
        if (selectUserByEmail(email) != null) {
            // true 不存在
            return true;
        } else {
            // false 存在
            return false;
        }
    }

    // 提交 修改用户表单
    public int iUpdateUser(User user) {
        // 修改密码后再加密
        ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        String md5 = new SimpleHash("md5", user.getPassword(), salt, 1024).toHex();
        user.setPassword(md5);
        // 判断邮箱是否相同 , 相同修改失败
        User findUserEmail = selectUserByEmail(user.getEmail());
        User findUsername = selectUserByName(user.getUsername());

        // System.out.println("数据库存在邮箱" + findUsername.getEmail());
        // System.out.println("输入邮箱" + user.getEmail());

        // 当前用户名邮箱与输入邮箱是否相同, 相同成功, 不相同判断数据库中是否存在
        // 当前用户邮箱 与 输入邮箱 是否相同
        if (user.getEmail().equals(findUsername.getEmail())) {
            // 相同更新
            updateUser(user);
            System.out.println("用户修改个人资料=>[" + user.getUsername() + "]");
            return 200;
        } else { // 输入邮箱与当前用户邮箱 不相同
            // 判断输入邮箱 在数据库中是否存在
            if (findUserEmail == null) {
                updateUser(user);
                System.out.println("用户修改个人资料=>[" + user.getUsername() + "]");
                return 200;
            } else {
                return 404;
            }
        }

    }

    // 弹出层 提交 修改用户表单
    public int adminUpdateUser(User user) {
        // 修改密码后再加密
        /*ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        String md5 = new SimpleHash("md5", user.getPassword(), salt, 1024).toHex();
        user.setPassword(md5);*/

//        System.out.println("数据库存在邮箱=>" + user1.getEmail());
//        System.out.println("输入邮箱=>" + user.getEmail());

        // 判断邮箱是否相同 , 相同修改失败
        User findUserEmail = selectUserByEmail(user.getEmail());
        User findUsername = selectUserByName(user.getUsername());

        // 当前用户名邮箱与输入邮箱是否相同, 相同成功, 不相同判断数据库中是否存在
        // 当前用户邮箱 与 输入邮箱 是否相同
        if (user.getEmail().equals(findUsername.getEmail())) {
            // 相同更新
            updateUser(user);
            System.out.println("用户修改个人资料=>[" + user.getUsername() + "]");
            return 200;
        } else { // 输入邮箱与当前用户邮箱 不相同
            // 判断输入邮箱 在数据库中是否存在
            if (findUserEmail == null) {
                updateUser(user);
                System.out.println("用户修改个人资料=>[" + user.getUsername() + "]");
                return 200;
            } else {
                return 404;
            }
        }
    }

    // 弹出层 提交 新增用户表单
    public int adminAddUser(User user) {
        // 将密码进行MD5 加盐加密
        ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        // 转为密文 ( 加密方式 , 明文密码 , 盐值 , 迭代次数 )
        String md5 = new SimpleHash("md5", user.getPassword(), salt, 1024).toHex();
        user.setPassword(md5);
        // 判断数据库中是否存在相同用户名 , 相同邮箱
        if (selectUserByName(user.getUsername()) == null
                && selectUserByEmail(user.getEmail()) == null) {
            System.out.println("admin新增用户信息=>[" + user + "]");
            // 保存到数据库中
            addUser(user);
            return 200;
        }
        return 404;
    }

    // 用户注册
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
        if (selectUserByName(username) == null && selectUserByEmail(email) == null) {
            // 保存到数据库中
            addUser(user);
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

    // 登录 , 获取 传来的 用户 , 密码
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
}
