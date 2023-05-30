package com.example.gochat.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("chatmessage")
@Data
public class ChatMessage {

    @TableId(type = IdType.AUTO)
    private Long message_id;

    @TableField("session_id")
    private Long session_id;

    @TableField("sender_id")
    private Long sender_id;

    @TableField("receiver_id")
    private Long receiver_id;

    @TableField("content")
    private String content;

    @TableField("timestamp")
    private String timestamp;

    public ChatMessage() {}
}
