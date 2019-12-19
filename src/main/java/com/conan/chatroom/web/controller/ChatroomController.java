package com.conan.chatroom.web.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.conan.chatroom.model.vo.ResponseJson;
import com.conan.chatroom.service.UserInfoService;
import com.conan.chatroom.util.Constant;

@Controller
@RequestMapping("/chatroom")
public class ChatroomController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * 描述：登录成功后，调用此接口进行页面跳转
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String toChatroom() {
        return "chatroom";
    }

    /**
     * 描述：登录成功跳转页面后，调用此接口获取用户信息
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/get_userinfo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson getUserInfo(HttpSession session) {
        Object userId = session.getAttribute(Constant.USER_TOKEN);
        return userInfoService.getByUserId((String) userId);
    }

    @RequestMapping(value = "/get_offlineMsg", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson get_offlineMsg(HttpSession session) {
        String userId = session.getAttribute(Constant.USER_TOKEN).toString();
        userInfoService.getOfflineMsg(userId);
        return new ResponseJson().success();
    }
}
