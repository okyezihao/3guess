package cn.yezihao.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // 3. ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        // 添加 Shiro 内置过滤器
        /*
         *  anon: 无需认证就可以访问
         *  authc: 必须认证才能访问
         *  user: 必须拥有记住我功能才能访问
         *  perms: 拥有对某个资源的权限才能访问
         *  role: 拥有某个角色权限才能访问
         *
         *  filterMap.put("/","anon");
         */

        // 登录拦截
        Map<String, String> filterMap = new LinkedHashMap<>();

        // filterMap.put("/admin/admin","perms[1]");
        filterMap.put("/admin/*", "perms[1]");

        filterMap.put("/admin/*", "authc");
//        filterMap.put("/toUserPage/", "authc");

        // 注销系统的过滤器
        filterMap.put("/logout", "logout");

        // 设置登录的请求
        bean.setLoginUrl("/toLogin");
        // 设置未授权请求 , 跳转未授权页面
        bean.setUnauthorizedUrl("/noAuth");
        // 设置授权成功跳转页面
        bean.setSuccessUrl("/index");
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    // 2. defaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联 UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 1. 创建 realm 对象 , 需要自定义!
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }


    // 整合 ShiroDialect: 用来整合 Shiro , Thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

}
