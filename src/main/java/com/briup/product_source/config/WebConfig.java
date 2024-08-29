package com.briup.product_source.config;


import com.briup.product_source.web.interceptor.JWTInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private JWTInterceptor jwtInterceptor;
    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("注册拦截器");
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")//请求拦截所有资源
                .excludePathPatterns("/swagger-resources/**",
                       "/webjars/**",
                        "/v2/api-docs/**",
                        ".swagger-ui.html",
                        "/csrf","/error","/");
    }
}
