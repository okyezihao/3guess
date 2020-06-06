package cn.yezihao.config;

import cn.yezihao.entity.User;
import cn.yezihao.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

// 自定义Realm , 继承认证类
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    // 授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 授权 SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取当前登录对象
        Subject subject = SecurityUtils.getSubject();
        // 获取 User对象
        User currentUser = (User) subject.getPrincipal();
        // 设置权限
        info.addStringPermission(currentUser.getRole());
        /* info.addStringPermission("user:add"); */

        System.out.println("执行授权=>["+currentUser.getUsername()+"]");

        // 接收 info 对象
        return info;
    }


    // 认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        // 连接数据库
        User user = userService.selectUserByName(userToken.getUsername());
        if (user == null) {
            // 没有此用户
            return null; // UnknownAccountException
        }

        System.out.println("执行认证=>["+user.getUsername()+"]");

        // 可加密 , md5加密: 827ccb0eea8a706c4c34a16891f84e7b , md5盐值加密: 827ccb0eea8a706c4c34a16891f84e7busername
        // 密码认证 shiro完成
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
