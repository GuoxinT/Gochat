package com.example.gochat.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("messagestatus")
public class Group {

    @TableId(type = IdType.AUTO)
    private Long group_id;

    @TableField("group_name")
    private String group_name;

    @TableField("creator_id")
    private String creator_id;

    public Group() {}
}
