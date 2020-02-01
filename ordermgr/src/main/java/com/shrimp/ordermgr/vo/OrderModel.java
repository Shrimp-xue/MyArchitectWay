package com.shrimp.ordermgr.vo;

import com.shrimp.common.vo.BaseModel;
import lombok.Data;

/**
 * @description: 订单信息实体类
 * @author: shrimp
 * @date: Created in 2020-01-31 15:47
 * @version: 1.0
 */
@Data
public class OrderModel extends BaseModel {
    private Integer customerUuid;
    private String orderTime;
    private Float totalMoney;
    private Float saveMoney ;
    private Integer state;
}
