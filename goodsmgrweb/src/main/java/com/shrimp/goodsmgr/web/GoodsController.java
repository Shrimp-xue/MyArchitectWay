package com.shrimp.goodsmgr.web;

import com.shrimp.util.JacksonUtil;
import org.springframework.ui.Model;

import com.shrimp.goodsmgr.service.IGoodsService;
import com.shrimp.goodsmgr.vo.GoodsModel;
import com.shrimp.goodsmgr.vo.GoodsQueryModel;
import com.shrimp.pageutil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: shrimp
 * @date: Created in 2020-01-29 15:03
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private IGoodsService iservice = null;

    /**
     * @Description: 请求添加商品页面
     * @Author Shrimp
     * @date: 2020-01-29 15:05
     * @Param: []
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "goods/add";
    }

    /**
     * @Description: 添加成功后返回成功页面
     * @Author Shrimp
     * @date: 2020-01-29 15:06
     * @Param: [goodsModel]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("goodsModel") GoodsModel goodsModel) {
        iservice.create(goodsModel);
        return "goods/success";
    }

    /**
     * @Description: 根据uuid 查询商品信息并跳转修改页面
     * @Author Shrimp
     * @date: 2020-01-29 15:10
     * @Param: [model, uuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toUpdate/{uuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("uuid") int uuid) {
        GoodsModel goodsModel = iservice.getByUuid(uuid);
        model.addAttribute("goodsModel", goodsModel);
        return "goods/update";
    }

    /**
     * @Description: 修改成功后返回成功页面
     * @Author Shrimp
     * @date: 2020-01-29 15:11
     * @Param: [goodsModel]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String post(@ModelAttribute("goodsModel") GoodsModel goodsModel) {
        iservice.update(goodsModel);
        return "goods/success";
    }

    /**
     * @Description: 根据uuid 查询购物车信息并跳转删除页面
     * @Author Shrimp
     * @date: 2020-01-29 15:11
     * @Param: [model, uuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toDelete/{uuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("uuid") int uuid) {
        GoodsModel goodsModel = iservice.getByUuid(uuid);
        model.addAttribute("goodsModel", goodsModel);
        return "goods/delete";
    }

    /**
     * @Description: 删除成功后返回成功页面
     * @Author Shrimp
     * @date: 2020-01-29 15:12
     * @Param: [uuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String post(@RequestParam("uuid") int uuid) {
        iservice.delete(uuid);
        return "goods/success";
    }

    /**
     * @Description: 查询购物车信息列表
     * @Author Shrimp
     * @date: 2020-01-29 15:12
     * @Param: [wm, model]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toList", method = RequestMethod.GET)
    public String toList(@ModelAttribute("wm") GoodsWebModel wm, Model model) {
        GoodsQueryModel qm = null;
        if (wm.getQueryJsonStr() == null || wm.getQueryJsonStr().trim().length() == 0) {
            qm = new GoodsQueryModel();
        } else {
            String s = wm.getQueryJsonStr();
            s = s.replace("-", "%");
            qm = (GoodsQueryModel) JacksonUtil.str2Object(s, GoodsQueryModel.class);
        }

        qm.getPage().setNowPage(wm.getNowPage());
        if (wm.getPageShow() > 0) {
            qm.getPage().setPageShow(wm.getPageShow());
        }

        Page dbPage = iservice.getByConditionPage(qm);

        //
        model.addAttribute("wm", wm);
        model.addAttribute("page", dbPage);

        return "goods/list";
    }

    /**
     * @Description: 查询方法
     * @Author Shrimp
     * @date: 2020-01-29 15:13
     * @Param: []
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toQuery", method = RequestMethod.GET)
    public String toQuery() {
        return "goods/query";
    }

}
