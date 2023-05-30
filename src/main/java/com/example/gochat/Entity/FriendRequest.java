package com.example.gochat.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("friendrequest")
@Data
public class FriendRequest {

    @TableId(type = IdType.AUTO)
    private Long request_id;

    @TableField("sender_id")
    private Long sender_id;

    @TableField("receiver_id")
    private Long receiver_id;

    public FriendRequest() {}
}
