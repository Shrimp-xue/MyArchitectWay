package com.shrimp.cartmgr.dao;

import com.shrimp.cartmgr.vo.CartModel;
import com.shrimp.cartmgr.vo.CartQueryModel;
import com.shrimp.common.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * @description: 购物车dao类
 * @author: shrimp
 * @date: Created in 2020-01-27 14:49
 * @version: 1.0
 */
@Repository
public interface CartDAO extends BaseDao<CartModel, CartQueryModel> {
}
