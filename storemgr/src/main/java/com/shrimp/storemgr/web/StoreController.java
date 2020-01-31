package com.shrimp.storemgr.web;

import com.shrimp.util.JacksonUtil;
import org.springframework.ui.Model;

import com.shrimp.pageutil.Page;
import com.shrimp.storemgr.service.IStoreService;
import com.shrimp.storemgr.vo.StoreModel;
import com.shrimp.storemgr.vo.StoreQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 库存信息控制层信息
 * @author: shrimp
 * @date: Created in 2020-01-31 16:19
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/store")
public class StoreController {

    @Autowired
    private IStoreService iStoreService = null;

    /**
     * @Description: 请求添加页面
     * @Author Shrimp
     * @date: 2020-01-31 16:25
     * @Param: []
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "store/add";
    }

    /**
     * @Description: 添加成功返回页面
     * @Author Shrimp
     * @date: 2020-01-31 16:25
     * @Param: [m]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("m") StoreModel m) {
        iStoreService.create(m);
        return "store/success";
    }

    /**
     * @Description: 请求修改页面
     * @Author Shrimp
     * @date: 2020-01-31 16:30
     * @Param: [model, uuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toUpdate/{uuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("uuid") int uuid) {
        StoreModel storeModel = iStoreService.getByUuid(uuid);
        model.addAttribute("storeModel", storeModel);
        return "store/update";
    }

    /**
     * @Description: 修改成功返回页面
     * @Author Shrimp
     * @date: 2020-01-31 16:30
     * @Param: [m]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String post(@ModelAttribute("m") StoreModel m) {
        iStoreService.update(m);
        return "store/success";
    }

    /**
     * @Description: 请求删除页面
     * @Author Shrimp
     * @date: 2020-01-31 16:31
     * @Param: [model, uuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toDelete/{uuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("uuid") int uuid) {
        StoreModel storeModel = iStoreService.getByUuid(uuid);
        model.addAttribute("storeModel", storeModel);
        return "store/delete";
    }

    /**
     * @Description: 删除成功页面
     * @Author Shrimp
     * @date: 2020-01-31 16:31
     * @Param: [uuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String post(@RequestParam("uuid") int uuid) {
        iStoreService.delete(uuid);
        return "store/success";
    }

    /**
     * @Description: 查询列表
     * @Author Shrimp
     * @date: 2020-01-31 16:32
     * @Param: [wm, model]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toList", method = RequestMethod.GET)
    public String toList(@ModelAttribute("wm") StoreWebModel wm, Model model) {
        StoreQueryModel qm = null;
        if (wm.getQueryJsonStr() == null || wm.getQueryJsonStr().trim().length() == 0) {
            qm = new StoreQueryModel();
        } else {
            String s = wm.getQueryJsonStr();
            s = s.replace("-", "%");
            qm = (StoreQueryModel) JacksonUtil.str2Object(s, StoreQueryModel.class);
        }

        qm.getPage().setNowPage(wm.getNowPage());
        if (wm.getPageShow() > 0) {
            qm.getPage().setPageShow(wm.getPageShow());
        }

        Page dbPage = iStoreService.getByConditionPage(qm);

        //
        model.addAttribute("wm", wm);
        model.addAttribute("page", dbPage);

        return "store/list";
    }

    /**
     * @Description: 请求查询页面
     * @Author Shrimp
     * @date: 2020-01-31 16:32
     * @Param: []
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toQuery", method = RequestMethod.GET)
    public String toQuery() {
        return "store/query";
    }
}
