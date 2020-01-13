package com.shrimp.customer.service.impl;

import com.shrimp.common.serivce.Impl.BaseService;
import com.shrimp.customer.dao.CustomerDAO;
import com.shrimp.customer.service.ICustomerService;
import com.shrimp.customer.vo.CustomerModel;
import com.shrimp.customer.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 客户信息serice 实现层
 * @author: shrimp
 * @date: Created in 2020-01-09 20:30
 * @version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerService extends BaseService<CustomerModel, CustomerQueryModel> implements ICustomerService {

    private CustomerDAO customerDAO = null;

    @Autowired
    private void setCustomerDAO(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
        super.setDao(customerDAO);
    }

}
