package com.shrimp.cartmgr.web;

import org.springframework.ui.Model;

import com.shrimp.cartmgr.service.ICartService;
import com.shrimp.cartmgr.vo.CartModel;
import com.shrimp.cartmgr.vo.CartQueryModel;
import com.shrimp.pageutil.Page;
import com.shrimp.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 购物车控制层
 * @author: shrimp
 * @date: Created in 2020-01-27 15:01
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private ICartService iservice = null;

    /**
     * @Description: 请求添加购物车页面
     * @Author Shrimp
     * @date: 2020-01-27 15:05
     * @Param: []
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "cart/add";
    }

    /**
     * @Description: 添加成功后返回成功页面
     * @Author Shrimp
     * @date: 2020-01-27 15:07
     * @Param: [m] 购物车实体类
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("cartModel") CartModel cartModel) {
        iservice.create(cartModel);
        return "cart/success";
    }

    /**
     * @Description: 根据uuid 查询购物车信息并跳转修改页面
     * @Author Shrimp
     * @date: 2020-01-27 15:08
     * @Param: [model, uuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/toUpdate/{uuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("uuid") int uuid) {
        CartModel cartModel = iservice.getByUuid(uuid);
        model.addAttribute("cartModel", cartModel);
        return "cart/update";
    }

    /**
     * @Description: 修改成功后返回成功页面
     * @Author Shrimp
     * @date: 2020-01-27 15:09
     * @Param: [m]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String post(@ModelAttribute("cartModel") CartModel cartModel) {
        iservice.update(cartModel);
        return "cart/success";
    }

    /**
     * @Description: 根据uuid 查询购物车信息并跳转删除页面
     * @Author Shrimp
     * @date: 2020-01-27 15:09
     * @Param: [model, uuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/toDelete/{uuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("uuid") int uuid) {
        CartModel cartModel = iservice.getByUuid(uuid);
        model.addAttribute("cartModel", cartModel);
        return "cart/delete";
    }

    /**
     * @Description: 删除成功后返回成功页面
     * @Author Shrimp
     * @date: 2020-01-27 15:10
     * @Param: [uuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String post(@RequestParam("uuid") int uuid) {
        iservice.delete(uuid);
        return "cart/success";
    }

    /**
     * @Description: 查询购物车信息列表
     * @Author Shrimp
     * @date: 2020-01-27 15:10
     * @Param: [wm, model]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/toList", method = RequestMethod.GET)
    public String toList(@ModelAttribute("wm") CartWebModel wm, Model model) {
        CartQueryModel qm = null;
        if (wm.getQueryJsonStr() == null || wm.getQueryJsonStr().trim().length() == 0) {
            qm = new CartQueryModel();
        } else {
            String s = wm.getQueryJsonStr();
            s = s.replace("-", "%");
            qm = (CartQueryModel) JacksonUtil.str2Object(s, CartQueryModel.class);
        }

        qm.getPage().setNowPage(wm.getNowPage());
        if (wm.getPageShow() > 0) {
            qm.getPage().setPageShow(wm.getPageShow());
        }

        Page dbPage = iservice.getByConditionPage(qm);

        model.addAttribute("wm", wm);
        model.addAttribute("page", dbPage);

        return "cart/list";
    }

    /**
     * @Description: 查询方法
     * @Author Shrimp
     * @date: 2020-01-27 15:10
     * @Param: []
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/toQuery", method = RequestMethod.GET)
    public String toQuery() {
        return "cart/query";
    }

}
