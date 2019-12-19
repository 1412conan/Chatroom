package com.conan.chatroom.service;

import com.conan.chatroom.model.vo.ResponseJson;

public interface UserInfoService {

    ResponseJson getByUserId(String userId);

    void getOfflineMsg(String userId);
}
