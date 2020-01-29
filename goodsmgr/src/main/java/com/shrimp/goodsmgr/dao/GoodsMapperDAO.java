package com.shrimp.goodsmgr.dao;

import com.shrimp.goodsmgr.vo.GoodsModel;
import com.shrimp.goodsmgr.vo.GoodsQueryModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 商品mapper映射接口层
 * @author: shrimp
 * @date: Created in 2020-01-29 14:46
 * @version: 1.0
 */
@Repository
public interface GoodsMapperDAO extends GoodsDAO {
    public List<Integer> getIdsByConditionPage(GoodsQueryModel gqm);
    public List<GoodsModel> getByIds(String ids);
}
