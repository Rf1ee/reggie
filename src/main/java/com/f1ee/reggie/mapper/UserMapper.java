package com.f1ee.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.f1ee.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息(User)表数据库访问层
 *
 * @author f1ee
 * @since 2022-11-10 14:11:39
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

