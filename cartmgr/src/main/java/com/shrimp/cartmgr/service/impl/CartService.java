package com.shrimp.cartmgr.service.impl;

import com.shrimp.cartmgr.dao.CartDAO;
import com.shrimp.cartmgr.service.ICartService;
import com.shrimp.cartmgr.vo.CartModel;
import com.shrimp.cartmgr.vo.CartQueryModel;
import com.shrimp.common.serivce.Impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 购物车service实现类
 * @author: shrimp
 * @date: Created in 2020-01-27 14:54
 * @version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CartService extends BaseService<CartModel, CartQueryModel> implements ICartService {

    private CartDAO cartDAO = null;

    @Autowired
    private void setCartDAO(CartDAO cartDAO){
        this.cartDAO = cartDAO;
        super.setDao(cartDAO);
    }
}
