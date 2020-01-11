package com.shrimp.common.serivce;

import com.shrimp.common.vo.BaseModel;
import com.shrimp.pageutil.Page;

/**
 * @description:
 * @author: shrimp
 * @date: Created in 2020-01-09 20:10
 * @version: 1.0
 */
public interface IBaseService<M ,QM extends BaseModel> {
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
    public Page<M> getByConditionPage(QM qm);
}
