package com.shrimp.customer.web;

import com.shrimp.customer.service.ICustomerService;
import com.shrimp.customer.vo.CustomerModel;
import com.shrimp.customer.vo.CustomerQueryModel;
import com.shrimp.pageUtil.Page;
import com.shrimp.util.format.DateFormatHelper;
import com.shrimp.util.json.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 客户信息控制层
 * @author: shrimp
 * @date: Created in 2020-01-11 15:01
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService = null;

    /**
     * @Description: 请求添加客户页面
     * @Author Shrimp
     * @date: 2020-01-11 15:35
     * @Param: []
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "customer/add";
    }

    /**
     * @Description: 添加成功后返回成功页面
     * @Author Shrimp
     * @date: 2020-01-11 15:38
     * @Param: [customerModel]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("customerModel") CustomerModel customerModel) {
        customerModel.setRegisterTime(DateFormatHelper.long2str(System.currentTimeMillis()));
        iCustomerService.create(customerModel);
        return "customer/success";
    }

    /**
     * @Description: 根据uuid 查询客户信息并跳转修改页面
     * @Author Shrimp
     * @date: 2020-01-11 15:42
     * @Param: [model, customerUuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/toUpdate/{customerUuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("customerUuid") int customerUuid) {
        CustomerModel customerModel = iCustomerService.getByUuid(customerUuid);
        model.addAttribute("cm", customerModel);
        return "customer/update";
    }

    /**
     * @Description: 修改成功后返回成功页面
     * @Author Shrimp
     * @date: 2020-01-11 15:38
     * @Param: [customerModel]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("customerModel") CustomerModel customerModel) {
        iCustomerService.update(customerModel);
        return "customer/success";
    }

    /**
     * @Description: 根据uuid 查询客户信息并跳转删除页面
     * @Author Shrimp
     * @date: 2020-01-11 15:42
     * @Param: [model, customerUuid]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/toDelete/{customerUuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("customerUuid") int customerUuid) {
        CustomerModel customerModel = iCustomerService.getByUuid(customerUuid);
        model.addAttribute("cm", customerModel);
        return "customer/delete";
    }

    /**
     * @Description: 删除成功后返回成功页面
     * @Author Shrimp
     * @date: 2020-01-11 15:38
     * @Param: [customerModel]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("uuid") int customerUuid) {
        iCustomerService.delete(customerUuid);
        return "customer/success";
    }

    /**
     * @Description: 查询客户信息列表
     * @Author Shrimp
     * @date: 2020-01-11 16:26
     * @Param: [queryJson, page, model]
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toList", method = RequestMethod.GET)
    public String toList(@ModelAttribute("customerWebModel") CustomerWebModel customerWebModel, Model model) {
        CustomerQueryModel cqm = null;
        if (customerWebModel.getQueryJsonStr() == null || customerWebModel.getQueryJsonStr().trim().length() == 0) {
            cqm = new CustomerQueryModel();
        } else {
            cqm = (CustomerQueryModel) JsonHelper.str2Object(customerWebModel.getQueryJsonStr(), CustomerQueryModel.class);
        }

        cqm.getPage().setNowPage(customerWebModel.getNowPage());
        if (customerWebModel.getPageShow() > 0) {
            cqm.getPage().setPageShow(customerWebModel.getPageShow());
        }

        Page dbPage = iCustomerService.getByConditionPage(cqm);
        //
        model.addAttribute("wm", customerWebModel);
        model.addAttribute("page", dbPage);
        return "customer/list";
    }

    /**
     * @Description:
     * @Author Shrimp
     * @date: 2020-01-11 16:42
     * @Param: []
     * @Return: java.lang.String
     **/
    @RequestMapping(value = "toQuery", method = RequestMethod.GET)
    public String toQuery() {
        return "customer/query";
    }
}
