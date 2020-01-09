package com.shrimp.customer.vo;

import com.shrimp.common.vo.BaseModel;
import lombok.Data;

/**
 * @description: 用户实体类
 * @author: shrimp
 * @date: Created in 2019-12-21 14:10
 * @version: 1.0
 * @modified By:
 */
@Data
public class CustomerModel extends BaseModel {
    private String customerId;
    private String pwd;
    private String showName;
    private String trueName;
    private String registerTime;

}
