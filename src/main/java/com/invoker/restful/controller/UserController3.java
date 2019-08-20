package com.invoker.restful.controller;

import com.invoker.restful.entity.Testuser;
import com.invoker.restful.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by invoker on 2019-08-20
 * Description:
 */
@RestController
@RequestMapping(value = "/users3")
public class UserController3 {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询单个用户", notes = "根据id查询单个用户")
    @GetMapping("/{id}")
    @ApiImplicitParam(name = "id", value = "用户id", required = true)
    public String queryUser(@PathVariable String id) {
        String queryUser = userService.queryUser(id);
        return "query user: " + queryUser;
    }

    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @GetMapping("/")
    public String queryUsers() {
        String allUsers0 = userService.getAllUser();
        return "query all users: " + allUsers0;
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping("/")
    public Integer addUser(@RequestBody Testuser user) {
        int insertUser = userService.insertUser(user);
        return insertUser;
    }

    // 普通接口  \ 上面是 restful 风格
//    @RequestMapping("/insertUser")
//    public Integer insertUser(Integer id, String name, String sex) {
//        int insertUser = userService.insertUser(id, name, sex);
//        return insertUser;
//    }

    @ApiOperation(value = "修改用户", notes = "修改用户")
    @PutMapping("/")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户信息json", required = true)
    })
    public String updateUser(@RequestBody Testuser user) {
        int updateUser = userService.updateUser(user);
        return "update user: " + updateUser;
    }

    @ApiOperation(value = "删除用户", notes = "根据id删除用户")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        int deleteUser = userService.deleteUser(id);
        return "delete user,id: " + deleteUser;
    }

}
