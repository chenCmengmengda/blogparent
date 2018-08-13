package com.blog.common.pojo;

import java.util.List;

/**
 * Created by 陈_C on 2018/7/11.
 */
public class EUDataGridResult {
    private long total;
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

}
