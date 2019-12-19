package com.conan.chatroom.dao;


import com.conan.chatroom.model.po.GroupInfo;

public interface GroupInfoDao {

    void loadGroupInfo();

    GroupInfo getByGroupId(String groupId);
}
	