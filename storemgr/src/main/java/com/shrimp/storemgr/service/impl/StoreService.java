package com.shrimp.storemgr.service.impl;

import com.shrimp.common.serivce.Impl.BaseService;
import com.shrimp.storemgr.dao.StoreDAO;
import com.shrimp.storemgr.service.IStoreService;
import com.shrimp.storemgr.vo.StoreModel;
import com.shrimp.storemgr.vo.StoreQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 库存信息service 实现类
 * @author: shrimp
 * @date: Created in 2020-01-31 16:16
 * @version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StoreService extends BaseService<StoreModel, StoreQueryModel> implements IStoreService {

    private StoreDAO storeDAO = null;

    @Autowired
    private void setDao(StoreDAO storeDAO){
        this.storeDAO = storeDAO;
        super.setDao(storeDAO);
    }

    @Override
    public StoreModel getByGoodsUuid(int goodsUuid) {
        return storeDAO.getByGoodsUuid(goodsUuid);
    }
}
