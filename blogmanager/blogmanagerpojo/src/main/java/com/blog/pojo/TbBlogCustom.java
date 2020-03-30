package com.blog.pojo;


/**
 * Created by 陈_C on 2018/8/20.
 */
public class TbBlogCustom extends TbBlog {

    private String blogDesc;

    private long blogCatId;

    private TbBlog preBlog;//上一篇
    private TbBlog nextBlog;//下一篇

    public String getBlogDesc() {
        return blogDesc;
    }

    public void setBlogDesc(String blogDesc) {
        this.blogDesc = blogDesc;
    }

    @Override
    public Long getBlogCatId() {
        return blogCatId;
    }

    public void setBlogCatId(long blogCatId) {
        this.blogCatId = blogCatId;
    }

    public TbBlog getPreBlog() {
        return preBlog;
    }

    public void setPreBlog(TbBlog preBlog) {
        this.preBlog = preBlog;
    }

    public TbBlog getNextBlog() {
        return nextBlog;
    }

    public void setNextBlog(TbBlog nextBlog) {
        this.nextBlog = nextBlog;
    }
}
