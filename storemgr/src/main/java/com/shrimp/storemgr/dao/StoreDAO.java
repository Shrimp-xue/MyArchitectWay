package com.shrimp.storemgr.dao;

import com.shrimp.common.dao.BaseDao;
import com.shrimp.storemgr.vo.StoreModel;
import com.shrimp.storemgr.vo.StoreQueryModel;
import org.springframework.stereotype.Repository;

/**
 * @description: 库存信息dao类
 * @author: shrimp
 * @date: Created in 2020-01-31 16:13
 * @version: 1.0
 */
@Repository
public interface StoreDAO extends BaseDao<StoreModel, StoreQueryModel> {
    public StoreModel getByGoodsUuid(int goodsUuid);
}
