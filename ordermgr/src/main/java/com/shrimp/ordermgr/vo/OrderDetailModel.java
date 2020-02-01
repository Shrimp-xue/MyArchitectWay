package com.shrimp.ordermgr.vo;

import com.shrimp.common.vo.BaseModel;
import lombok.Data;

/**
 * @description: 订单详情信息实体类
 * @author: shrimp
 * @date: Created in 2020-01-31 15:41
 * @version: 1.0
 */
@Data
public class OrderDetailModel extends BaseModel {

    private Integer orderUuid;
    private Integer goodsUuid;
    private Integer orderNum;
    private Float price;
    private Float money;
    private Float saveMoney;
}
