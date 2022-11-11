package com.f1ee.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.f1ee.reggie.entity.Orders;

/**
 * 订单表(Orders)表服务接口
 *
 * @author f1ee
 * @since 2022-11-10 21:53:03
 */
public interface OrdersService extends IService<Orders> {
    /**
     * 用户下单
     * @param orders
     */
    void submits(Orders orders);
}

