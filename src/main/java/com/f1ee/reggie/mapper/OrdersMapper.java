package com.f1ee.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.f1ee.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表(Orders)表数据库访问层
 *
 * @author f1ee
 * @since 2022-11-10 21:53:02
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}

