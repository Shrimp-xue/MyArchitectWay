package com.shrimp.util.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 通用的Ajax请求结果
 * @author: shrimp
 * @date: Created in 2020-01-11 19:03
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResult {
    private String result;
    private String resultDesc;
    private Object data;
}
