package com.shrimp.customer.vo;

import lombok.Data;

import java.util.Objects;

/**
 * @description:
 * @author: shrimp
 * @date: Created in 2019-12-21 14:10
 * @version: 用户实体类
 * @modified By:
 */
@Data
public class CustomerModel {
    private Integer uuid;
    private String customerId;
    private String pwd;
    private String showName;
    private String trueName;
    private String registerTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerModel that = (CustomerModel) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

}
