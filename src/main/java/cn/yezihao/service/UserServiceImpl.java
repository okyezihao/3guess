package cn.yezihao.service;

import cn.yezihao.dao.UserDao;
import cn.yezihao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
