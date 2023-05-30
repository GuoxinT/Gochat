package com.example.gochat.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.gochat.Entity.User;
import com.example.gochat.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(@Valid JSONObject data, MultipartFile photo) {
        User user = new User(data.get("password").toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insert(user);
    }

    public Boolean login(Map<String, String> map) {
        String user_id = map.get("user_id");
        String password = map.get("password");
        System.out.println(password);
        System.out.println(passwordEncoder.encode(password));

        User val = userMapper.selectById(user_id);
        System.out.println(passwordEncoder.matches(password, val.getPassword()));
        return passwordEncoder.matches(password, val.getPassword());
    }
}
