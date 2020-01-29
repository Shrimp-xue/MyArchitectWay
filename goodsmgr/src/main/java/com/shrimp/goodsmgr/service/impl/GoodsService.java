package com.shrimp.goodsmgr.service.impl;

import com.shrimp.common.serivce.Impl.BaseService;
import com.shrimp.goodsmgr.dao.GoodsDAO;
import com.shrimp.goodsmgr.service.IGoodsService;
import com.shrimp.goodsmgr.vo.GoodsModel;
import com.shrimp.goodsmgr.vo.GoodsQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: shrimp
 * @date: Created in 2020-01-29 14:50
 * @version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodsService extends BaseService<GoodsModel, GoodsQueryModel> implements IGoodsService {

    private GoodsDAO goodsDAO = null;

    @Autowired
    private void setDao(GoodsDAO goodsDAO){
        this.goodsDAO = goodsDAO;
        super.setDao(goodsDAO);
    }

}
