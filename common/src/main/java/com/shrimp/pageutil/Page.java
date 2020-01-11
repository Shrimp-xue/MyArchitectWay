package com.shrimp.pageutil;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @description: 分页实体类
 * @author: shrimp
 * @date: Created in 2020-01-05 17:12
 * @version: 1.0
 * @modified By:
 */
@Data
public class Page<E> implements Serializable {
    private int pageShow = 2;
    private int totalPage;
    private int totalCount;
    private int start;
    private int  nowPage;
    private List<E> result = Collections.emptyList();

    public int getStart(){
        start =(getNowPage() -1 )* getPageShow();
        if(start < 0){
            start = 0;
        }
        return start;
    }

    public int getTotalPage(){
        return (int)Math.ceil(totalCount * 1.0/pageShow);
    }

    public int getNowPage(){
        if(nowPage <= 0){
            nowPage = 1;
        }
        if (nowPage > getTotalPage()){
            nowPage = getTotalPage();
        }
        return nowPage;
    }

}
