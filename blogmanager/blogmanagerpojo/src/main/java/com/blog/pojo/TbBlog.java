package com.blog.pojo;

import java.util.Date;

public class TbBlog {
    private Long id;

    private String title;

    private String imageUrl;

    private Date createTime;

    private Date updateTime;

    private Long blogCatId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
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

    public Long getBlogCatId() {
        return blogCatId;
    }

    public void setBlogCatId(Long blogCatId) {
        this.blogCatId = blogCatId;
    }
}