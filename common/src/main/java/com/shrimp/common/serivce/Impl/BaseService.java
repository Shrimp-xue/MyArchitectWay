package com.shrimp.common.serivce.Impl;

import com.shrimp.common.dao.BaseDao;
import com.shrimp.common.serivce.IBaseService;
import com.shrimp.common.vo.BaseModel;
import com.shrimp.pageutil.Page;

import java.util.List;

/**
 * @description:
 * @author: shrimp
 * @date: Created in 2020-01-09 20:14
 * @version: 1.0
 */
public class BaseService<M, QM extends BaseModel> implements IBaseService<M, QM> {

    private BaseDao dao = null;

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }

    @Override
    public void create(M m) {
        dao.create(m);
    }

    @Override
    public void update(M m) {
        dao.update(m);
    }

    @Override
    public void delete(int uuid) {
        dao.delete(uuid);
    }

    @Override
    public M getByUuid(int uuid) {
        return (M)dao.getByUuid(uuid);
    }

    @Override
    public Page<M> getByConditionPage(QM qm) {
        List<M> list = dao.getByConditionPage(qm);
        qm.getPage().setResult(list);
        return qm.getPage();
    }
}
