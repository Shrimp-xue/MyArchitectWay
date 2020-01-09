package com.shrimp.common.vo;

import com.shrimp.pageUtil.Page;
import lombok.Data;

import java.util.Objects;

/**
 * @description:
 * @author: shrimp
 * @date: Created in 2020-01-09 20:20
 * @version: 1.0
 */
@Data
public class BaseModel {

    private Integer uuid;

    private Page page = new Page();

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseModel)) return false;
        BaseModel baseModel = (BaseModel) o;
        return Objects.equals(uuid, baseModel.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
