package com.example.gochat.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("chatsession")
@Data
public class ChatSession {

    @TableId(type = IdType.AUTO)
    private Long session_id;

    @TableField("user1_id")
    private Long user1_id;

    @TableField("user2_id")
    private Long user2_id;

    public ChatSession() {}
}
