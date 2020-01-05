package com.shrimp.customer.dao;

import com.shrimp.customer.vo.CustomerQueryModel;
import com.shrimp.customer.vo.CustomerModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: shrimp
 * @date: Created in 2019-12-21 14:24
 * @version: 用户接口层
 * @modified By:
 */
@Repository
public interface CustomerDAO {

    /**
     * @description 增加用户
     * @author shrimp
     * @date 2019-12-21 14:26
      * @param null
     * @return
     */
    public void create(CustomerModel customerModel);

    /**
     * @description 修改用户
     * @author shrimp
     * @date 2019-12-21 14:28
      * @param null
     * @return
     */
    public void update(CustomerModel customerModel);

    /**
     * @description 删除用户
     * @author shrimp
     * @date 2019-12-21 14:28
      * @param null
     * @return
     */
    public void delete(int uuid);

    /**
     * @description 根据主键查询用户
     * @author shrimp
     * @date 2019-12-21 14:28
      * @param null
     * @return
     */
    public CustomerModel getByUuid(int uuid);

    /**
     * @description 根据条件查询用户
     * @author shrimp
     * @date 2019-12-21 14:29
      * @param null
     * @return
     */
    public List<CustomerModel> getByCondition(CustomerQueryModel cusotmerQueryModel);

}
