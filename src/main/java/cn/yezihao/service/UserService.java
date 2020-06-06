package cn.yezihao.service;

import cn.yezihao.entity.User;

import java.util.List;

public interface UserService {

    // 新增用户
    int addUser(User user);

    // 删除用户
    int deleteUser(Integer id);

    // 修改用户资料
    int updateUser(User user);

    // 查询 所有用户
    List<User> findAllUser();

    // 查询 用户 ById
    User findUserById(Integer id);

    // 查询用户 ByName
    User selectUserByName(String username);

    // 查询 用户 ByEmail
    User selectUserByEmail(String email);

    // 模糊查询
    List<User> selectUserBySearch(String search);

}
