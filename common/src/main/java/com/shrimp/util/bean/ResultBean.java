package com.shrimp.util.bean;

import lombok.Data;

/**
 * @description: 通用的结果集封装
 * @author: shrimp
 * @date: Created in 2020-01-11 18:57
 * @version: 1.0
 */
@Data
public class ResultBean {
    private String code;
    private Object data;
    private boolean success = false;

    public ResultBean() {
    }

    public ResultBean(String code, Object data, boolean success) {
        this.code = code;
        this.data = data;
        this.success = success;
    }
}
