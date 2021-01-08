package com.my.servermvc.entity;

/**
 * @Description: 分页查询参数
 * @Author: lh
 * @Date 2020/9/15
 * @Version: 1.0
 **/
public class QueryInfo {
    private String query;
    private Integer pageNum;
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "QueryInfo{" +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
