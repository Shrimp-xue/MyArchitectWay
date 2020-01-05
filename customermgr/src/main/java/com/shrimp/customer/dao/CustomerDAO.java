package com.shrimp.customer.dao;

import com.shrimp.common.dao.BaseDao;
import com.shrimp.customer.vo.CustomerQueryModel;
import com.shrimp.customer.vo.CustomerModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 用户接口层
 * @author: shrimp
 * @date: Created in 2019-12-21 14:24
 * @version: 1.0
 * @modified By:
 */
@Repository
public interface CustomerDAO extends BaseDao<CustomerModel, CustomerQueryModel> {

}
