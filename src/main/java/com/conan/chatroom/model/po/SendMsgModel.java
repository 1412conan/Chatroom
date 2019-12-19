package com.conan.chatroom.model.po;

import java.io.Serializable;

/**
 * 消息对象
 *
 * @author conan
 */
public class SendMsgModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;//接收消息用戶

    private String fromUserId;//发送消息用户

    private String content;//消息内容

    private String type;//发送类型

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
