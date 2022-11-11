package com.f1ee.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.f1ee.reggie.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

/**
 * 购物车(ShoppingCart)表数据库访问层
 *
 * @author f1ee
 * @since 2022-11-10 18:25:42
 */
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

}

