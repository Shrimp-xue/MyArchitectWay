package com.shrimp.storemgr.vo;

import com.shrimp.common.vo.BaseModel;
import lombok.Data;

/**
 * @description: 库存信息实体类
 * @author: shrimp
 * @date: Created in 2020-01-31 16:10
 * @version: 1.0
 */
@Data
public class StoreModel extends BaseModel {
    private Integer goodsUuid;
    private Integer storeNum;
}
