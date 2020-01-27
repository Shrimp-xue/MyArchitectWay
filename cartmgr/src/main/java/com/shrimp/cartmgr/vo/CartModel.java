package com.shrimp.cartmgr.vo;

import com.shrimp.common.vo.BaseModel;
import lombok.Data;

/**
 * @description: 购物车实体类
 * @author: shrimp
 * @date: Created in 2020-01-27 14:44
 * @version: 1.0
 */
@Data
public class CartModel extends BaseModel {
    private Integer customerUuid;
    private Integer goodsUuid;
    private Integer buyNum;
}
