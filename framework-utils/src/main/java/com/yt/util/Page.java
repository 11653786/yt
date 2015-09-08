package com.yt.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2015/9/8.
 */
public class Page {

    private Integer page = 1;       //当前页数
    private Integer pageSize = 10;   //每页显示数量
    private Integer total;      //总共多少条
    private Integer taotalPage; //总共多少页
    private List list = new ArrayList();


    public Page() {
    }


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page < 1) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(pageSize>1){
            this.pageSize = pageSize;
        }
    }

    public Integer getTotal() {
        return list.size();
    }

    public Integer getTaotalPage() {
        if (total % pageSize == 0) {
            return total % pageSize;
        } else {
            return total % pageSize + 1;
        }
    }


    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
