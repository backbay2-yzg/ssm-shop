package com.backbay2.shop.service.impl;


import com.backbay2.shop.dao.UserMapper;
import com.backbay2.shop.pojo.User;
import com.backbay2.shop.pojo.UserExample;
import com.backbay2.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 蒋松冬 on 2017/7/22.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> selectByExample(UserExample userExample) {
        return userMapper.selectByExample(userExample);
    }

    @Override
    public void insertSelective(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void deleteUserById(Integer userid) {
        userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public void updateByPrimaryKeySelective(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }


   /* @Override
    public User selectByPrimaryKeyAndPassword(int userId,String password){return userMapper.selectByPrimaryKeyAndPassword();}*/
}
