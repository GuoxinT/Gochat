package com.example.gochat.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("groupmessage")
public class GroupMessage {

    @TableId(type = IdType.AUTO)
    private Long message_id;

    @TableField("group_id")
    private String group_id;

    @TableField("sender_id")
    private String sender_id;

    @TableField("content")
    private String content;

    @TableField("timestamp")
    private String timestamp;

    public GroupMessage() {}
}
