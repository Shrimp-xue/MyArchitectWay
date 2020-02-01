package com.shrimp.ordermgr.service;

import com.shrimp.common.serivce.IBaseService;
import com.shrimp.ordermgr.vo.OrderModel;
import com.shrimp.ordermgr.vo.OrderQueryModel;

/**
 * @description: 订单信息service层
 * @author: shrimp
 * @date: Created in 2020-01-31 15:53
 * @version: 1.0
 */
public interface IOrderService extends IBaseService<OrderModel, OrderQueryModel> {
    public void order(int customerUuid);
}
