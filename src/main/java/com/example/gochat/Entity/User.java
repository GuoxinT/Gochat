package com.example.gochat.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.constraints.NotBlank;

@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long user_id;

    @NotBlank(message = "Password is required")
    private String password;

    public User() {};

    public User(String password) {
        this.password = password;
    }
}
