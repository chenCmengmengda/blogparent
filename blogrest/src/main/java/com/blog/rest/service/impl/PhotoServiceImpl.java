package com.blog.rest.service.impl;

import com.blog.common.pojo.ListDataResult;
import com.blog.mapper.TbPhotolistMapper;
import com.blog.pojo.TbBlog;
import com.blog.pojo.TbBlogExample;
import com.blog.pojo.TbPhotolist;
import com.blog.pojo.TbPhotolistExample;
import com.blog.rest.service.PhotoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    TbPhotolistMapper photolistMapper;


    @Override
    public ListDataResult getPhotoList(Integer page, Integer rows) {
        //查询博客列表
        TbPhotolistExample example=new TbPhotolistExample();
        //分页处理
        PageHelper.startPage(page,rows);
        List<TbPhotolist> list=photolistMapper.selectByExample(example);
        ListDataResult result=new ListDataResult();
        result.setPage(page);//当前页
        List<TbPhotolist> lists=new ArrayList<>();
        List<List<TbPhotolist>> listList=new ArrayList<>();

        for(TbPhotolist photolist:list){

            lists.add(photolist);

            if(lists.size()==2){
                listList.add(lists);
                lists=new ArrayList<>();
            }

        }
        if(lists.size()==1){
            listList.add(lists);
        }
        result.setRows(listList);
        //取总博客数
        PageInfo<TbPhotolist> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());//总信息数
        result.setPages(pageInfo.getPages());//总页数
        System.out.println(pageInfo.getTotal()+":"+pageInfo.getPages());
        return result;

    }
}
