package com.shrimp.customer;

import com.shrimp.common.Base1;

/**
 * @description:
 * @author: shrimp
 * @date: Created in 2019-12-09 21:25
 * @version: 1.0
 * @modified By:
 */
public class Customer1 {

    public  void c1(String s){
        new Base1().base1("customer1 invoke====");
        System.out.println("now in Customer1====="+s);
    }
}
