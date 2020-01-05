package com.shrimp.common.dao;

import java.util.List;

/**
 * @Description 基础dao
 * @ClassName BaseDao
 * @Author Shrimp
 * @date 2020.01.05 18:08
 */
public interface BaseDao<M, QM> {

    /**
     * @description 增加用户
     * @author shrimp
     * @date 2019-12-21 14:26
     * @param m
     * @return
     */
    public void create(M m);

    /**
     * @description 修改用户
     * @author shrimp
     * @date 2019-12-21 14:28
     * @param m
     * @return
     */
    public void update(M m);

    /**
     * @description 删除用户
     * @author shrimp
     * @date 2019-12-21 14:28
     * @param uuid
     * @return
     */
    public void delete(int uuid);

    /**
     * @description 根据主键查询用户
     * @author shrimp
     * @date 2019-12-21 14:28
     * @param uuid
     * @return
     */
    public M getByUuid(int uuid);

    /**
     * @description 根据条件查询用户
     * @author shrimp
     * @date 2019-12-21 14:29
     * @param qm
     * @return
     */
    public List<M> getByConditionPage(QM qm);
}
