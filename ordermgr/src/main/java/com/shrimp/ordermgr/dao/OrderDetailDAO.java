package com.shrimp.ordermgr.dao;

import com.shrimp.common.dao.BaseDao;
import com.shrimp.ordermgr.vo.OrderDetailModel;
import com.shrimp.ordermgr.vo.OrderDetailQueryModel;
import org.springframework.stereotype.Repository;

/**
 * @description: 订单详情信息dao层
 * @author: shrimp
 * @date: Created in 2020-01-31 15:51
 * @version: 1.0
 */
@Repository
public interface OrderDetailDAO extends BaseDao<OrderDetailModel, OrderDetailQueryModel> {
}
