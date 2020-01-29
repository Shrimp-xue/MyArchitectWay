package com.shrimp.goodsmgr.dao;

import com.shrimp.common.dao.BaseDao;
import com.shrimp.goodsmgr.vo.GoodsModel;
import com.shrimp.goodsmgr.vo.GoodsQueryModel;
import org.springframework.stereotype.Repository;


/**
 * @description: 商品接口层
 * @author: shrimp
 * @date: Created in 2020-01-29 14:44
 * @version: 1.0
 */
//@Repository
public interface GoodsDAO extends BaseDao<GoodsModel, GoodsQueryModel> {

}
