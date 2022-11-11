package com.f1ee.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.f1ee.reggie.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单明细表(OrderDetail)表数据库访问层
 *
 * @author f1ee
 * @since 2022-11-10 21:53:04
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}

