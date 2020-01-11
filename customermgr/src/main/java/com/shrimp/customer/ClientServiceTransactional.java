package com.shrimp.customer;

import com.shrimp.customer.service.ICustomerService;
import com.shrimp.customer.vo.CustomerModel;
import com.shrimp.customer.vo.CustomerQueryModel;
import com.shrimp.pageutil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 测试 service 层 + Transactional 调用数据库
 * @author: shrimp
 * @date: Created in 2020-01-05 16:39
 * @version: 1.0
 * @modified By:
 */
@Service
@Transactional
public class ClientServiceTransactional {

    @Autowired
    private ICustomerService iCustomerService = null;

    /**
     * 说明：这里当 ClientServiceTransactional 类上添加 @Transactional 注解时，
     * Page<CustomerModel> page = client.iCustomerService.getByConditionPage(customerQueryModel);
     * 调用的是 Transactional 的代理对象，这个原始对象 private ICustomerService iCustomerService = null 是存在的。
     * 也就是说，通过 client.iCustomerService 调用的是两个不同的对象,Transactional 代理的属性丢失；
     *
     * 只有通过 Transactional 代理的方法 getICustomerService() 来获取。
     * Page<CustomerModel> page = client.getICustomerService().getByConditionPage(customerQueryModel);
     **/
    public ICustomerService getICustomerService(){
        return iCustomerService;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClientServiceTransactional client = (ClientServiceTransactional)ctx.getBean("clientServiceTransactional");


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
        Page<CustomerModel> page = client.getICustomerService().getByConditionPage(customerQueryModel);
        System.out.println("page==" + page);
    }

}
