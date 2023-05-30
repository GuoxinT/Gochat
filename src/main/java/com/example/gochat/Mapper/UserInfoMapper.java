package com.example.gochat.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.gochat.Entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
