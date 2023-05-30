package com.example.gochat.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("groupmember")
@Data
public class GroupMember {

    @TableId(type = IdType.AUTO)
    private Long group_id;

    @TableField("user_id")
    private Long user_id;

    @TableField("role")
    private String role;

    public GroupMember() {}
}
