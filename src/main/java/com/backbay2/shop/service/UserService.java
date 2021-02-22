package com.backbay2.shop.service;


import com.backbay2.shop.pojo.User;
import com.backbay2.shop.pojo.UserExample;

import java.util.List;

/**
 * Created by 蒋松冬 on 2017/7/20.
 */
public interface UserService {
    public User selectByPrimaryKey(int userId);

    /*public User selectByPrimaryKeyAndPassword(int userId,String password);*/
    public List<User> selectByExample(UserExample userExample);

    public void insertSelective(User user);

    public void deleteUserById(Integer userid);

    public void updateByPrimaryKeySelective(User user);

}
