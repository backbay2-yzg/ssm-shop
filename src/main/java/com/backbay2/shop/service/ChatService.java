package com.backbay2.shop.service;


import com.backbay2.shop.pojo.Chat;
import com.backbay2.shop.pojo.ChatExample;

import java.util.List;

/**
 * Created by 文辉 on 2017/7/26.
 */
public interface ChatService {
    public void insertChatSelective(Chat chat);

    public List<Chat> selectChatByExample(ChatExample chatExample);
}
