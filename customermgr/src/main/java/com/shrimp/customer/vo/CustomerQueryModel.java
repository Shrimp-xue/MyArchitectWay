package com.shrimp.customer.vo;

import com.shrimp.pageUtil.Page;
import lombok.Data;

/**
 * @description: 用来封装查询条件
 * @author: shrimp
 * @date: Created in 2019-12-21 14:23
 * @version: 1.0
 * @modified By:
 */
@Data
public class CustomerQueryModel extends CustomerModel {

    private Page<CustomerModel> page = new Page<CustomerModel>();

}
