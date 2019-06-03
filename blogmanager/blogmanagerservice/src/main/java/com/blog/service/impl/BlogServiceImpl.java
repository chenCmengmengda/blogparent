package com.blog.service.impl;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.common.util.IDUtils;
import com.blog.mapper.TbBlogCatMapper;
import com.blog.mapper.TbBlogCustomMapper;
import com.blog.mapper.TbBlogDescMapper;
import com.blog.mapper.TbBlogMapper;
import com.blog.pojo.*;
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
    @Autowired
    TbBlogCatMapper blogCatMapper;

    @Override
    public Result createBlog(TbBlogWithBLOBs blog) throws Exception {
        //blog补全
        Long blogId= IDUtils.genItemId();
        blog.setId(blogId);
        //添加摘要,取前20个
        String str=removeTag(blog.getBlogDesc());
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
 /*       Result result=createBlogDesc(blogId,desc);
        if(result.getStatus()!=200){
            throw new Exception();
        }
*/
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
        List<TbBlogWithBLOBs> list=blogMapper.selectByExampleWithBLOBs(example);
        //创建一个返回值对象
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbBlogWithBLOBs> pageInfo=new PageInfo<>(list);
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
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public Result editBlog(TbBlogWithBLOBs blog) throws Exception {
        //blog补全
        //添加摘要,取前20个
        String str=removeTag(blog.getBlogDesc());
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
     /*   Result result=editBlogDesc(blog.getId(),desc);
        if(result.getStatus()!=200){
            throw new Exception();
        }
*/
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
    public Result findOne(long id){
        TbBlogWithBLOBs blog=  blogMapper.selectByPrimaryKey(id);
         return Result.ok(blog);
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
        for(Long id:ids){
            blogDescMapper.deleteByPrimaryKey(id);
        }
        return  Result.ok();
    }

    /**
     * 查询最新文章
     * @param rows
     * @return
     */
    @Override
    public Result getNewBlogTitle(Integer rows){
        PageHelper.startPage(1,rows);
        List<TbBlog> list=blogCustomMapper.getNewBlogTitle();
        return Result.ok(list);

    }

    /**
     * 获取博客类别列表
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EUDataGridResult getBlogCatList(Integer page, Integer rows) {
        TbBlogCatExample example=new TbBlogCatExample();
        //分页处理
        PageHelper.startPage(page,rows);
        List<TbBlogCat> list=blogCatMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbBlogCat> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Result addBlogCat(TbBlogCat blogCat){
        blogCat.setId(IDUtils.genItemId());
        Date date=new Date();
        blogCat.setCreateTime(date);
        blogCat.setUpdateTime(date);
        blogCatMapper.insert(blogCat);
        return Result.ok();
    }

    @Override
    public Result editBlogCat(TbBlogCat blogCat){
        Date date=new Date();
        blogCat.setUpdateTime(date);
        blogCatMapper.updateByPrimaryKey(blogCat);
        return Result.ok();
    }

    /**
     * 删除博客类别
     * @param ids
     * @return
     */
    @Override
    public Result deleteBlogCat(Long[] ids){
        for(Long id:ids){
            blogCatMapper.deleteByPrimaryKey(id);
        }
        return Result.ok();
    }




}
