package com.conan.chatroom.dao;

import com.conan.chatroom.model.po.UserInfo;

public interface UserInfoDao {

    void loadUserInfo();

    UserInfo getByUsername(String username);

    UserInfo getByUserId(String userId);
}
