package com.blog.pojo;

import java.util.Date;

public class TbPhotolist {
    private Long photoId;

    private String photoTitle;

    private String photoExplain;

    private String photoImages;

    private Date createTime;

    private Date updateTime;

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getPhotoTitle() {
        return photoTitle;
    }

    public void setPhotoTitle(String photoTitle) {
        this.photoTitle = photoTitle == null ? null : photoTitle.trim();
    }

    public String getPhotoExplain() {
        return photoExplain;
    }

    public void setPhotoExplain(String photoExplain) {
        this.photoExplain = photoExplain == null ? null : photoExplain.trim();
    }

    public String getPhotoImages() {
        return photoImages;
    }

    public void setPhotoImages(String photoImages) {
        this.photoImages = photoImages == null ? null : photoImages.trim();
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
}