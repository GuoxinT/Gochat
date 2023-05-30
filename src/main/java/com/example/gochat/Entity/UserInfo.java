package com.example.gochat.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("userinfo")
public class UserInfo {

    @TableId(type = IdType.AUTO)
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

    UserInfo() {}
}
