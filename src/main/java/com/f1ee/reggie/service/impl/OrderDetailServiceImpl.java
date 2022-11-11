package com.f1ee.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.f1ee.reggie.mapper.OrderDetailMapper;
import com.f1ee.reggie.entity.OrderDetail;
import com.f1ee.reggie.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * 订单明细表(OrderDetail)表服务实现类
 *
 * @author f1ee
 * @since 2022-11-10 21:53:04
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}

