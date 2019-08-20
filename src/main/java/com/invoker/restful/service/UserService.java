package com.invoker.restful.service;

import com.invoker.restful.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(Integer id, String name, String sex) {
        int insertResult = userMapper.insert(id, name, sex);
        return insertResult;
    }

}
