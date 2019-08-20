package com.invoker.restful.service;

import com.google.gson.Gson;
import com.invoker.restful.entity.Testuser;
import com.invoker.restful.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    Gson gson = new Gson();

    @Autowired
    private UserMapper userMapper;

    // 查询单个用户
    public String queryUser(String id) {
        Testuser queryUser = userMapper.getUserById(id);
        return queryUser.getId() + "," + queryUser.getName() + "," + queryUser.getSex();
    }

    // 查询所有用户
    public String getAllUser() {
        List<Testuser> allUser = userMapper.getAllUser();
        return gson.toJson(allUser);
    }

    // 新增用户
    public int insertUser(Testuser user) {
        int insertResult = userMapper.insert(user);
        return insertResult;
    }

//    public int insertUser(Integer id, String name, String sex) {
//        int insertResult = userMapper.insert(id, name, sex);
//        return insertResult;
//    }

    // 修改用户信息
    public int updateUser(Testuser user) {
        int insertResult = userMapper.update(user);
        return insertResult;
    }

    // 删除用户信息
    public int deleteUser(Integer id) {
        int insertResult = userMapper.deleteUserById(id);
        return insertResult;
    }
}
