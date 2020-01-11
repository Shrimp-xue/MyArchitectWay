package com.shrimp.util.functions;

/**
 * @description: 定义一些处理接口，便于优雅的处理一些数据,实现的方法返回数据
 * @author: shrimp
 * @date: Created in 2020-01-11 18:01
 * @version: 1.0
 */
public interface ObjectProcess<T, E> {
    E process(T t);
}
