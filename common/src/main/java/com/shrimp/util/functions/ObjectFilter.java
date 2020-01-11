package com.shrimp.util.functions;

/**
 * @description: 对象过滤接口
 * @author: shrimp
 * @date: Created in 2020-01-11 18:00
 * @version: 1.0
 */
public interface ObjectFilter<T> {
    boolean filter(T t);
}
