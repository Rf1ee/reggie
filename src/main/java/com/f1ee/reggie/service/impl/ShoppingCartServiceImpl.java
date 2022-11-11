package com.f1ee.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.f1ee.reggie.mapper.ShoppingCartMapper;
import com.f1ee.reggie.entity.ShoppingCart;
import com.f1ee.reggie.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * 购物车(ShoppingCart)表服务实现类
 *
 * @author f1ee
 * @since 2022-11-10 18:25:43
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}

