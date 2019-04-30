package com.blog.pojo;

import java.util.Date;

public class TbMessage {
    private Long id;

    private String username;

    private String email;

    private Date createTime;

    private Long myreplyId;

    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getMyreplyId() {
        return myreplyId;
    }

    public void setMyreplyId(Long myreplyId) {
        this.myreplyId = myreplyId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}