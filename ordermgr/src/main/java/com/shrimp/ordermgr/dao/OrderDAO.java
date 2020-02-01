package com.shrimp.ordermgr.dao;

import com.shrimp.common.dao.BaseDao;
import com.shrimp.ordermgr.vo.OrderModel;
import com.shrimp.ordermgr.vo.OrderQueryModel;
import org.springframework.stereotype.Repository;

/**
 * @description: 订单信息dao层
 * @author: shrimp
 * @date: Created in 2020-01-31 15:50
 * @version: 1.0
 */
@Repository
public interface OrderDAO extends BaseDao<OrderModel, OrderQueryModel> {
}
