package com.shrimp.goodsmgr.vo;

import com.shrimp.common.vo.BaseModel;
import lombok.Data;

/**
 * @description: 商品信息实体类
 * @author: shrimp
 * @date: Created in 2020-01-29 14:42
 * @version: 1.0
 */
@Data
public class GoodsModel extends BaseModel {
    private String name;
    private String imgPath;
    private String description;
}
