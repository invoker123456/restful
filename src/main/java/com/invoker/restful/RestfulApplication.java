package com.invoker.restful;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//扫描同级包及子包
@MapperScan(basePackages = {"com.invoker.restful.mapper"})
//在mapper中不用添加注解，在此处指明要扫描的mapper所在的包路径。通过反射技术读取该包下面的所有类
public class RestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApplication.class, args);
    }

}
