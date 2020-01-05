package com.shrimp.customer;

import com.shrimp.customer.dao.CustomerDAO;
import com.shrimp.customer.vo.CustomerModel;
import com.shrimp.customer.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 测试
 * @author: shrimp
 * @date: Created in 2020-01-05 16:39
 * @version: 1.0
 * @modified By:
 */
@Service
public class Client {

    @Autowired
    private CustomerDAO dao = null;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Client client = (Client)ctx.getBean("client");


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
        List<CustomerModel> list = client.dao.getByConditionPage(customerQueryModel);
        System.out.println("list==" + list);
    }

}
