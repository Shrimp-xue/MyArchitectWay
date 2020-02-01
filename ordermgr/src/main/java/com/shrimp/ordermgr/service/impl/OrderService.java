package com.shrimp.ordermgr.service.impl;

import com.shrimp.cartmgr.service.ICartService;
import com.shrimp.cartmgr.vo.CartModel;
import com.shrimp.cartmgr.vo.CartQueryModel;
import com.shrimp.common.serivce.Impl.BaseService;
import com.shrimp.ordermgr.dao.OrderDAO;
import com.shrimp.ordermgr.service.IOrderDetailService;
import com.shrimp.ordermgr.service.IOrderService;
import com.shrimp.ordermgr.vo.OrderDetailModel;
import com.shrimp.ordermgr.vo.OrderModel;
import com.shrimp.ordermgr.vo.OrderQueryModel;
import com.shrimp.pageutil.Page;
import com.shrimp.storemgr.service.IStoreService;
import com.shrimp.storemgr.vo.StoreModel;
import com.shrimp.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @description: 订单信息service 实现层
 * @author: shrimp
 * @date: Created in 2020-01-31 15:54
 * @version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService extends BaseService<OrderModel, OrderQueryModel> implements IOrderService {

    private OrderDAO orderDAO = null;

    @Autowired
    private ICartService iCartService = null;

    @Autowired
    private IOrderDetailService iOrderDetailService = null;

    @Autowired
    private IStoreService iStoreService = null;

    @Autowired
    private void setDao(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
        super.setDao(orderDAO);
    }

    @Override
    public void order(int customerUuid) {

        long a = System.currentTimeMillis();
        //消息的消费者来完成如下功能
        CartQueryModel cqm = new CartQueryModel();
        cqm.getPage().setPageShow(1000);
        cqm.setCustomerUuid(customerUuid);

        Page<CartModel> page = iCartService.getByConditionPage(cqm);
        //2:
        float totalMoney = 0.0f;
        for (CartModel cm : page.getResult()) {
            totalMoney += 10;
        }

        OrderModel order = new OrderModel();
        order.setCustomerUuid(customerUuid);
        order.setOrderTime(DateUtil.long2str(System.currentTimeMillis()));
        order.setSaveMoney(0.0F);
        order.setTotalMoney(totalMoney);
        order.setState(1);

        create(order);

        OrderQueryModel oqm = new OrderQueryModel();
        oqm.setOrderTime(order.getOrderTime());

        Page<OrderModel> orderPage = getByConditionPage(oqm);
        order = orderPage.getResult().get(0);

        //3:
        for (CartModel cm : page.getResult()) {
            OrderDetailModel odm = new OrderDetailModel();
            odm.setGoodsUuid(cm.getGoodsUuid());
            odm.setOrderNum(cm.getBuyNum());
            odm.setPrice(10.0f);
            odm.setMoney(odm.getPrice() * odm.getOrderNum());
            odm.setSaveMoney(0.0f);
            odm.setOrderUuid(order.getUuid());

            iOrderDetailService.create(odm);
            //4:
            StoreModel storeModel = iStoreService.getByGoodsUuid(cm.getGoodsUuid());
            storeModel.setStoreNum(storeModel.getStoreNum() - odm.getOrderNum());
            iStoreService.update(storeModel);

            //5:
            //			ics.delete(cm.getUuid());
        }

        long a2 = System.currentTimeMillis();
        System.out.println("NONO send one msg time===" + (a2 - a));
    }
}
