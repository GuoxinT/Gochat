package com.example.gochat.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.gochat.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
