package com.conan.chatroom.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.conan.chatroom.dao.GroupInfoDao;
import com.conan.chatroom.model.po.GroupInfo;
import com.conan.chatroom.model.po.UserInfo;
import com.conan.chatroom.util.Constant;

@Repository
public class GroupInfoDaoImpl implements GroupInfoDao {

    @Override
    public void loadGroupInfo() {
//        UserInfo userInfo = new UserInfo("001", "Member001", "001", "static/img/avatar/Member001.jpg");
//        UserInfo userInfo2 = new UserInfo("002", "Member002", "002", "static/img/avatar/Member002.jpg");
//        UserInfo userInfo3 = new UserInfo("003", "Member003", "003", "static/img/avatar/Member003.jpg");
//        UserInfo userInfo4 = new UserInfo("004", "Member004", "004", "static/img/avatar/Member004.jpg");
//        UserInfo userInfo5 = new UserInfo("005", "Member005", "005", "static/img/avatar/Member005.jpg");
//        UserInfo userInfo6 = new UserInfo("006", "Member006", "006", "static/img/avatar/Member006.jpg");
//        UserInfo userInfo7 = new UserInfo("007", "Member007", "007", "static/img/avatar/Member007.jpg");
//        UserInfo userInfo8 = new UserInfo("008", "Member008", "008", "static/img/avatar/Member008.jpg");
//        UserInfo userInfo9 = new UserInfo("009", "Member009", "009", "static/img/avatar/Member009.jpg");

        UserInfo userInfo11 = new UserInfo("011", "zk", "123456", "static/img/avatar/Member001.jpg");
        UserInfo userInfo12 = new UserInfo("012", "xjl", "123456", "static/img/avatar/Member002.jpg");
        UserInfo userInfo13 = new UserInfo("013", "hqh", "123456", "static/img/avatar/Member003.jpg");
        UserInfo userInfo14 = new UserInfo("014", "fhq", "123456", "static/img/avatar/Member004.jpg");

//        List<UserInfo> members = new ArrayList<UserInfo>();
//        members.add(userInfo);
//        members.add(userInfo2);
//        members.add(userInfo3);
//        members.add(userInfo4);
//        members.add(userInfo5);
//        members.add(userInfo6);
//        members.add(userInfo7);
//        members.add(userInfo8);
//        members.add(userInfo9);

        List<UserInfo> members2 = new ArrayList<UserInfo>();
        members2.add(userInfo11);
        members2.add(userInfo12);
        members2.add(userInfo13);
        members2.add(userInfo14);

//        GroupInfo groupInfo = new GroupInfo("01", "Group01", "static/img/avatar/Group01.jpg", members);
//        Constant.groupInfoMap.put(groupInfo.getGroupId(), groupInfo);

        GroupInfo groupInfo2 = new GroupInfo("02", "拉呱群", "static/img/avatar/Group01.jpg", members2);
        Constant.groupInfoMap.put(groupInfo2.getGroupId(), groupInfo2);
    }

    @Override
    public GroupInfo getByGroupId(String groupId) {
        return Constant.groupInfoMap.get(groupId);
    }

}
