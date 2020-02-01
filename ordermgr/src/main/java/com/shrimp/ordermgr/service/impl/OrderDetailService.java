package com.shrimp.ordermgr.service.impl;

import com.shrimp.common.serivce.Impl.BaseService;
import com.shrimp.ordermgr.dao.OrderDetailDAO;
import com.shrimp.ordermgr.service.IOrderDetailService;
import com.shrimp.ordermgr.vo.OrderDetailModel;
import com.shrimp.ordermgr.vo.OrderDetailQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 订单详情信息 service 实现层
 * @author: shrimp
 * @date: Created in 2020-01-31 15:57
 * @version: 1.0
 */
//@Service
//@Transactional(rollbackFor = Exception.class)
public class OrderDetailService extends BaseService<OrderDetailModel, OrderDetailQueryModel> implements IOrderDetailService {

    //private OrderDetailDAO orderDetailDAO = null;
    //
    //@Autowired
    //private void setDao(OrderDetailDAO orderDetailDAO) {
    //    this.orderDetailDAO = orderDetailDAO;
    //    super.setDao(orderDetailDAO);
    //}
}
