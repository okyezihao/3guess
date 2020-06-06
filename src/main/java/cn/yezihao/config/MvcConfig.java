package cn.yezihao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Mvc 配置
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // 自定义 跳转页面
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
    }

}
