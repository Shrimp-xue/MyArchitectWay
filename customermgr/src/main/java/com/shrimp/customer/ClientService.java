package com.shrimp.customer;

import com.shrimp.customer.dao.CustomerDAO;
import com.shrimp.customer.service.ICustomerService;
import com.shrimp.customer.vo.CustomerModel;
import com.shrimp.customer.vo.CustomerQueryModel;
import com.shrimp.pageUtil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 测试service 层调用数据库
 * @author: shrimp
 * @date: Created in 2020-01-05 16:39
 * @version: 1.0
 * @modified By:
 */
@Service
public class ClientService {

    @Autowired
    private ICustomerService iCustomerService = null;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClientService client = (ClientService)ctx.getBean("clientService");


        // 测试create 方法
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomerId("c2");
        customerModel.setPwd("c2");
        customerModel.setRegisterTime("111");
        customerModel.setShowName("c2");
        customerModel.setTrueName("张三2");
        //client.dao.create(customerModel);

        CustomerQueryModel customerQueryModel = new CustomerQueryModel();
        customerQueryModel.getPage().setNowPage(1);
        Page<CustomerModel> page = client.iCustomerService.getByConditionPage(customerQueryModel);
        System.out.println("page==" + page);
    }

}
