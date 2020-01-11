package com.shrimp.util.bean;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * @description: 存放字段属性信息
 * @author: shrimp
 * @date: Created in 2020-01-11 18:50
 * @version: 1.0
 */
@Data
public class BeanStruct {
    //字段的名字
    private String fieldName;
    //字段的类型
    private Object fieldType;
    //字段值读方法
    private Method readMethod;
    //字段值写方法
    private Method writeMethod;
    private boolean isDeclared;

    public BeanStruct(String fieldName, Object fieldType, Method readMethod, Method writeMethod, boolean isDeclared) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.readMethod = readMethod;
        this.writeMethod = writeMethod;
    }

}
