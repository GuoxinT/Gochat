package com.example.gochat.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("friendship")
@Data
public class FriendShip {

    @TableId(type = IdType.AUTO)
    private Long friendship_id;

    @TableField("user_id")
    private Long user_id;

    @TableField("friend_id")
    private Long friend_id;

    public FriendShip() {}
}
