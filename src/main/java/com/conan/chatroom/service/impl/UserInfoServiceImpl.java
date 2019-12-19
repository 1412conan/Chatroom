package com.conan.chatroom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conan.chatroom.dao.UserInfoDao;
import com.conan.chatroom.model.po.SendMsgModel;
import com.conan.chatroom.model.po.UserInfo;
import com.conan.chatroom.model.vo.ResponseJson;
import com.conan.chatroom.service.UserInfoService;
import com.conan.chatroom.util.ChatType;
import com.conan.chatroom.util.Constant;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public ResponseJson getByUserId(String userId) {
        UserInfo userInfo = userInfoDao.getByUserId(userId);
        return new ResponseJson().success()
                .setData("userInfo", userInfo);
    }

    @Override
    public void getOfflineMsg(String userId) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ChannelHandlerContext toUserCtx = Constant.onlineUserMap.get(userId);
        // 1 获取用户的离线消息
        List<SendMsgModel> offlineMsgs = Constant.offlineMsgMap.get(userId);

        if (offlineMsgs == null) {
            return;
        }

        for (SendMsgModel sendMsgModel : offlineMsgs) {
            String responseJson = new ResponseJson().success()
                    .setData("fromUserId", sendMsgModel.getFromUserId())
                    .setData("content", sendMsgModel.getContent())
                    .setData("type", ChatType.SINGLE_SENDING)
                    .toString();
            sendMessage(toUserCtx, responseJson);
        }
        Constant.offlineMsgMap.put(userId, null);
    }

    private void sendMessage(ChannelHandlerContext ctx, String message) {
        ctx.channel().writeAndFlush(new TextWebSocketFrame(message));
    }
}
