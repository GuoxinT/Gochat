package com.example.gochat.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("messagestatus")
@Data
public class MessageStatus {

    @TableId(type = IdType.AUTO)
    private Long status_id;

    @TableField("message_id")
    private String message_id;

    @TableField("user_id")
    private String user_id;

    @TableField("status")
    private String status; // 0 1 2 已发送、已接收、已读取

    public MessageStatus() {}
}
