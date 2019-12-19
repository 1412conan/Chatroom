package com.conan.chatroom.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/voice")
public class VoiceController {

    @RequestMapping(method = RequestMethod.GET)
    public String toVoice() {
        return "voice";
    }

}
