package com.shrimp.util.factory;

import com.shrimp.Constant;
import com.shrimp.util.entity.AjaxResult;

/**
 * @description:
 * @author: shrimp
 * @date: Created in 2020-01-11 19:02
 * @version: 1.0
 */
public class ResultFactory {
    /**
     * 请求成功
     *
     * @param data
     * @return
     */
    public static AjaxResult success(Object data) {
        AjaxResult result = new AjaxResult();
        result.setResult(Constant.SYS_SUCCESS);
        result.setResultDesc(Constant.SYS_SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 请求错误
     *
     * @param errorMsg
     * @return
     */
    public static AjaxResult error(String errorMsg) {
        AjaxResult result = new AjaxResult();
        result.setResult(Constant.SYS_ERROR);
        result.setResultDesc(errorMsg);
        result.setData("");
        return result;
    }

    public static AjaxResult error(String errorMsg, Object data) {
        AjaxResult result = new AjaxResult();
        result.setResult(Constant.SYS_ERROR);
        result.setResultDesc(errorMsg);
        result.setData(data);
        return result;
    }

    /**
     * 请求异常
     *
     * @param errorMsg
     * @return
     */
    public static AjaxResult exception(String errorMsg) {
        AjaxResult result = new AjaxResult();
        result.setResult(Constant.SYS_EXCEPTION);
        result.setResultDesc(errorMsg);
        result.setData("");
        return result;
    }

    /**
     * 未登录
     *
     * @return
     */
    public static AjaxResult noLogin() {
        AjaxResult result = new AjaxResult();
        result.setResult(Constant.SYS_NOLOGIN);
        result.setResultDesc("当前用户为登录");
        result.setData("");
        return result;
    }

    /**
     * 未找到记录
     */
    public static AjaxResult noRecord() {
        AjaxResult result = new AjaxResult();
        result.setResult(Constant.SYS_NORECORD);
        result.setResultDesc("未找到相应的记录");
        result.setData("");
        return result;
    }
}
