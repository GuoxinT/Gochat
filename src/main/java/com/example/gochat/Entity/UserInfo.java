package com.example.gochat.Entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.gochat.Utility.util;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@TableName("userinfo")
public class UserInfo {

    @TableField("user_id")
    private Long user_id;

    @TableField("username")
    private String username;

    @TableField("age")
    private Integer age;

    @TableField("photo")
    private String photo;

    @TableField("email")
    private String email;

    @TableField("sex")
    private String sex;

    @TableField("birthdate")
    private String birthdate;

    public UserInfo() {}

    public UserInfo(JSONObject map) {
        user_id = util.Long(map.get("user_id").toString());
        username = map.get("username").toString();
        age = util.Int(map.get("age").toString());
        photo = map.get("photo").toString();
        email = map.get("email").toString();
        sex = map.get("sex").toString();
        birthdate = map.get("birthdate").toString();
    }
}
