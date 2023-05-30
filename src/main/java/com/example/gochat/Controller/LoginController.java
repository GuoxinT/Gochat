package com.example.gochat.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.gochat.Exception.jsonResult;
import com.example.gochat.Service.UserService;
import com.example.gochat.Utility.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api/v1.0/")
public class LoginController {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    UserService service;

    @Value("${spring.mail.username}")
    private String username;

    @PostMapping("login")
    public jsonResult login(@RequestBody Map<String, String> map) {
        /*
            username: xxx
            password: xxx
        */
        if (service.login(map)) return jsonResult.success("登录成功");
        return jsonResult.error(400, "登录失败");
    }

    @PostMapping("register")
    public jsonResult register(@RequestBody String data,
                         @RequestParam("photo") MultipartFile photo) {
        /*
            username: xxx
            password: xxx
            email: xxx
            sex: xxx
            photo: xxx
            birth_date
         */
        JSONObject jsonObject = JSONObject.parseObject(data);
        System.out.println(jsonObject);

        service.register(jsonObject, photo);
        return jsonResult.success("注册成功");
    }

    @PostMapping("sendverification")
    public jsonResult sendVerification(@RequestBody Map<String, String> map, HttpSession session) {
        String email = map.get("email");
        Thread t = new Thread(() -> {
            SimpleMailMessage msg = new SimpleMailMessage();
            //邮件的主题
            msg.setSubject("GoChat注册验证码");
            //邮件的内容
            String code = util.RandomCode();
            msg.setText("本次登录的验证码: " + code);
            session.setAttribute("mail_verify_code", code);
            //邮件的发送方，对应配置文件中的spring.mail.username
            msg.setFrom(username);
            //邮件发送时间
            msg.setSentDate(new Date());
            //邮件接收方
            msg.setTo(email);
            //执行发送
            javaMailSender.send(msg);
        });

        t.start();
        return jsonResult.success("验证码已发送到邮箱，请注意查看 !");
    }
}
