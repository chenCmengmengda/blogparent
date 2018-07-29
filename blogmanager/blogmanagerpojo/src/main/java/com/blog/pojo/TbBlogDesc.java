package com.blog.pojo;

import java.util.Date;

public class TbBlogDesc {
    private Long blogId;

    private Date createTime;

    private Date updateTime;

    private String blogDesc;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBlogDesc() {
        return blogDesc;
    }

    public void setBlogDesc(String blogDesc) {
        this.blogDesc = blogDesc == null ? null : blogDesc.trim();
    }
}