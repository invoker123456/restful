package com.invoker.restful.controller;

import com.invoker.restful.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by invoker on 2019-08-20
 * Description:
 */
@RestController
public class UserController3 {
    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    public Integer insertUser(Integer id, String name, String sex) {
        int insertUser = userService.insertUser(id, name, sex);
        return insertUser;
    }
}
