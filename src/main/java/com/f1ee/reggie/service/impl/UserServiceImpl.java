package com.f1ee.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.f1ee.reggie.mapper.UserMapper;
import com.f1ee.reggie.entity.User;
import com.f1ee.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户信息(User)表服务实现类
 *
 * @author f1ee
 * @since 2022-11-10 14:11:39
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

