package com.ujs.stupool.config;
import com.ujs.stupool.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class webConfig implements WebMvcConfigurer {

    List<String> patterns=new ArrayList<>();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        patterns.add("/login");
        patterns.add("/register");
        patterns.add("/hot");
        patterns.add("/fetchcomment/*");
        patterns.add("/postdetail/*");
        patterns.add("/subarea");
        patterns.add("/static/**");
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 可限制哪个请求可以通过跨域
                .allowedHeaders("*")  // 可限制固定请求头可以通过跨域
                .allowedMethods("*") // 可限制固定methods可以通过跨域
                .allowedOriginPatterns("*"); // 可限制访问ip可以通过跨;
    }



}
