package com.example.gochat.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/")
public class RelativeController {

    // 添加好友
    @PostMapping("addfriend")
    public void addFriend() {

    }

}
