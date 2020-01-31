package com.shrimp.storemgr.service;

import com.shrimp.common.serivce.IBaseService;
import com.shrimp.storemgr.vo.StoreModel;
import com.shrimp.storemgr.vo.StoreQueryModel;

/**
 * @description: 库存信息service层
 * @author: shrimp
 * @date: Created in 2020-01-31 16:15
 * @version: 1.0
 */
public interface IStoreService extends IBaseService<StoreModel, StoreQueryModel> {
    public StoreModel getByGoodsUuid(int goodsUuid);
}
