package com.fayayo.vo;

import java.util.List;

/**
 * @author dalizu on 2018/12/28.
 * @version v1.0
 * @desc 分页工具类
 */
public class PageData<T> {

    private int total=0;//总数

    private int pageSize=20;//每页查询数

    private int currentPage=1;

    private int totalPage=1;

    private List<T> rows=null;


    public PageData(int total, int pageSize, int currentPage, List<T> rows) {
        this.total = total;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.rows = rows;

        //计算总页数
        this.totalPage=total % pageSize ==0 ? total / pageSize: total /pageSize+1;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
