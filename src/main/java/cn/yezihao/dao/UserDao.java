package cn.yezihao.dao;

import cn.yezihao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    // 查询所有用户
    List<User> findAllUser();

    // 通过 用户名 查询用户
    User selectUserByName(@Param("username") String username);

    // 新增用户
    int addUser(User user);

    // 通过 邮箱 查询用户
    User selectUserByEmail(@Param("email") String email);

    // 修改用户资料
    int updateUser(User user);

    // 模糊查询
    List<User> selectUserBySearch(@Param("search") String search);

    // 通过id查询用户
    User findUserById(@Param("id") Integer id);

    // 删除用户
    int deleteUser(@Param("id") Integer id);

}
