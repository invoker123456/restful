package com.invoker.restful.controller;

import com.google.gson.Gson;
import com.invoker.restful.entity.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by invoker on 2019-08-06
 * Description: RESTful api + Swagger2
 * Swagger2可以利用注解快速、自动地生成接口文档页面，方便调用方查阅！
 * <p>
 * POST及PUT方法中，使用@RequestBody时，仅支持content-type:application/json；使用@ModelAttribute时，仅支持content-type:application/x-www-form-urlencoded（已亲测，至于为什么请细看相关注解的具体实现）
 * <p>
 * 作者：yuanzicheng
 * 链接：https://www.jianshu.com/p/79e6f2dca03b
 * 来源：简书
 * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 */
@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    Gson gson = new Gson();

    @ApiOperation(value = "查询单个用户", notes = "根据id查询单个用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiImplicitParam(name = "id", value = "用户id", required = true)
    public String queryUser(@PathVariable long id) {
        return "query user: " + id;
    }

    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String queryUsers() {
        return "query all users";
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        return "add user:" + gson.toJson(user);
    }

    @ApiOperation(value = "修改用户", notes = "修改用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true),
            @ApiImplicitParam(name = "user", value = "用户信息json", required = true)
    })
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        return "update user,id:" + id + ",user:" + gson.toJson(user);
    }

    @ApiOperation(value = "删除用户", notes = "根据id删除用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        return "delete user,id:" + id;
    }
}
