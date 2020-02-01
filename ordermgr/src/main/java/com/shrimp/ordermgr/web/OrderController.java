package com.shrimp.ordermgr.web;

import com.shrimp.ordermgr.service.IOrderService;
import com.shrimp.ordermgr.vo.OrderModel;
import com.shrimp.ordermgr.vo.OrderQueryModel;
import com.shrimp.pageutil.Page;
import com.shrimp.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

/**
 * @description: 订单信息Controller 层
 * @author: shrimp
 * @date: Created in 2020-02-01 15:00
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private IOrderService iservice = null;

    /**
     * @Description: 跳转订单添加页面
     * @Author Shrimp
     * @date: 2020-02-01 15:24
     * @Param: []
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "order/add";
    }

    /**
     * @Description: 订单添加成功
     * @Author Shrimp
     * @date: 2020-02-01 15:25
     * @Param: [m]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("orderModel") OrderModel orderModel) {
        iservice.create(orderModel);
        return "order/success";
    }

    /**
     * @Description: 跳转订单修改页面
     * @Author Shrimp
     * @date: 2020-02-01 15:26
     * @Param: [model, uuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toUpdate/{uuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("uuid") int uuid) {
        OrderModel orderModel = iservice.getByUuid(uuid);
        model.addAttribute("orderModel", orderModel);
        return "order/update";
    }

    /**
     * @Description: 订单修改成功
     * @Author Shrimp
     * @date: 2020-02-01 15:47
     * @Param: [m]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String post(@ModelAttribute("orderModel") OrderModel orderModel) {
        iservice.update(orderModel);
        return "order/success";
    }

    /**
     * @Description: 跳转订单删除页面
     * @Author Shrimp
     * @date: 2020-02-01 15:47
     * @Param: [model, uuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toDelete/{uuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("uuid") int uuid) {
        OrderModel orderModel = iservice.getByUuid(uuid);
        model.addAttribute("orderModel", orderModel);
        return "order/delete";
    }

    /**
     * @Description: 订单删除成功
     * @Author Shrimp
     * @date: 2020-02-01 15:48
     * @Param: [uuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String post(@RequestParam("uuid") int uuid) {
        iservice.delete(uuid);
        return "order/success";
    }

    /**
     * @Description: 订单查询列表
     * @Author Shrimp
     * @date: 2020-02-01 15:48
     * @Param: [wm, model]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toList", method = RequestMethod.GET)
    public String toList(@ModelAttribute("wm") OrderWebModel wm, Model model) {
        OrderQueryModel qm = null;
        if (wm.getQueryJsonStr() == null || wm.getQueryJsonStr().trim().length() == 0) {
            qm = new OrderQueryModel();
        } else {
            String s = wm.getQueryJsonStr();
            s = s.replace("-", "%");
            qm = (OrderQueryModel) JacksonUtil.str2Object(s, OrderQueryModel.class);
        }

        qm.getPage().setNowPage(wm.getNowPage());
        if (wm.getPageShow() > 0) {
            qm.getPage().setPageShow(wm.getPageShow());
        }

        Page dbPage = iservice.getByConditionPage(qm);

        //
        model.addAttribute("wm", wm);
        model.addAttribute("page", dbPage);

        return "order/list";
    }

    /**
     * @Description: 订单查询页面
     * @Author Shrimp
     * @date: 2020-02-01 15:48
     * @Param: []
     * @Return: java.lang.String
     *
     **/
    @RequestMapping(value = "toQuery", method = RequestMethod.GET)
    public String toQuery() {
        return "order/query";
    }
}
