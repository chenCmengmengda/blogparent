package com.blog.service.impl;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.common.util.IDUtils;
import com.blog.mapper.TbBlogCustomMapper;
import com.blog.mapper.TbBlogDescMapper;
import com.blog.mapper.TbBlogMapper;
import com.blog.pojo.TbBlog;
import com.blog.pojo.TbBlogCustom;
import com.blog.pojo.TbBlogDesc;
import com.blog.pojo.TbBlogExample;
import com.blog.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 陈_C on 2018/8/7.
 */
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    TbBlogMapper blogMapper;
    @Autowired
    TbBlogDescMapper blogDescMapper;
    @Autowired
    TbBlogCustomMapper blogCustomMapper;

    @Override
    public Result createBlog(TbBlog blog, String desc) throws Exception {
        //blog补全
        Long blogId= IDUtils.genItemId();
        blog.setId(blogId);
        //添加摘要,取前20个
        String str=removeTag(desc);
        String summary=null;
        int summartLen=20;
        if(str.length()<summartLen){
            summary = "摘要：" + str.replace(" ", "").substring(0);
        }else {
            summary = "摘要：" + str.replace(" ", "").substring(0, 20);
        }
        blog.setSummary(summary);
        //添加时间
        Date date = new Date();
        blog.setCreateTime(date);
        blog.setUpdateTime(date);
        //插入数据库
        blogMapper.insert(blog);
        //添加博客内容
        Result result=createBlogDesc(blogId,desc);
        if(result.getStatus()!=200){
            throw new Exception();
        }

        return Result.ok();
    }

    /**
     * 过滤html标签
     * @param htmlStr
     * @return
     */
    private static String removeTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // script
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // style
        String regEx_html = "<[^>]+>"; // HTML tag
        String regEx_space = "\\s+|\t|\r|\n";// other characters

        Pattern p_script = Pattern.compile(regEx_script,
                Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll("");
        Pattern p_style = Pattern
                .compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll("");
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll("");
        Pattern p_space = Pattern
                .compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(" ");
        return htmlStr;
    }

    /**
     * 插入博客内容
     * @param blogId
     * @param desc
     * @return
     */
    private Result createBlogDesc(Long blogId,String desc){
        TbBlogDesc blogDesc=new TbBlogDesc();
        blogDesc.setBlogId(blogId);
        blogDesc.setBlogDesc(desc);
        Date date=new Date();
        blogDesc.setCreateTime(date);
        blogDesc.setUpdateTime(date);
        blogDescMapper.insert(blogDesc);
        return Result.ok();
    }

    /**
     * 返回博客列表
     * @param page 当前页数
     * @param rows 一页行数
     * @return
     */
    @Override
    public EUDataGridResult blogList(int page,int rows){
        TbBlogExample example=new TbBlogExample();
        //分页处理
        PageHelper.startPage(page,rows);
        List<TbBlog> list=blogMapper.selectByExampleWithBLOBs(example);
        //创建一个返回值对象
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbBlog> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Result readBlog(Long id){
        return Result.ok(blogDescMapper.selectByPrimaryKey(id));
    }

    /**
     * 编辑博客
     * @param blog
     * @param desc
     * @return
     * @throws Exception
     */
    @Override
    public Result editBlog(TbBlog blog, String desc) throws Exception {
        //blog补全
        //添加摘要,取前20个
        String str=removeTag(desc);
        String summary=null;
        int summartLen=20;
        if(str.length()<summartLen){
            summary = "摘要：" + str.replace(" ", "").substring(0);
        }else {
            summary = "摘要：" + str.replace(" ", "").substring(0, 20);
        }
        blog.setSummary(summary);
        //添加时间
        Date date = new Date();
        blog.setUpdateTime(date);
        //插入数据库
        blogMapper.updateByPrimaryKeyWithBLOBs(blog);
        //添加博客内容
        Result result=editBlogDesc(blog.getId(),desc);
        if(result.getStatus()!=200){
            throw new Exception();
        }

        return Result.ok();
    }

    /**
     * 修改博客内容
     * @param blogId
     * @param desc
     * @return
     */
    private Result editBlogDesc(Long blogId,String desc){
        TbBlogDesc blogDesc=new TbBlogDesc();
        blogDesc.setBlogId(blogId);
        blogDesc.setBlogDesc(desc);
        Date date=new Date();
        blogDesc.setUpdateTime(date);
        blogDescMapper.updateByPrimaryKeyWithBLOBs(blogDesc);
        return Result.ok();
    }

    @Override
    public TbBlogCustom findOne(long id){
        List <TbBlogCustom> blogCustom=blogCustomMapper.getBlogListById(id);
         return blogCustom.get(0);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @Override
    public Result deleteBlog(Long[] ids){
        for(Long id:ids){
            blogMapper.deleteByPrimaryKey(id);
        }
        return  Result.ok();
    }

}
