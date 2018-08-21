package com.blog.common.pojo;

import java.util.List;

/**
 * 列表数据结果pojo
 * Created by 陈_C on 2018/8/19.
 */
public class ListDataResult {
    private long total;
    private long pages;
    private List<?> rows;
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<?> getRows() {
        return rows;
    }
    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }
}
