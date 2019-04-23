package com.blog.service.impl;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.common.util.IDUtils;
import com.blog.mapper.TbPhotolistMapper;
import com.blog.pojo.TbBlog;
import com.blog.pojo.TbPhotolist;
import com.blog.pojo.TbPhotolistExample;
import com.blog.service.PhotoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private TbPhotolistMapper photolistMapper;


    /**
     *
     *
     * @param page 当前页数
     * @param rows 每页所取行数
     * @return easyUI表格格式对象
     */
    @Override
    public EUDataGridResult getPhotoList(int page,int rows){
        TbPhotolistExample example=new TbPhotolistExample();
        //分页处理
        PageHelper.startPage(page,rows);//设置固定8行
        List<TbPhotolist> list=photolistMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbPhotolist> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;

    }

    @Override
    public Result addPhoto(TbPhotolist photolist){
        Long photolistId= IDUtils.genItemId();
        photolist.setPhotoId(photolistId);
        //添加时间
        Date date = new Date();
        photolist.setCreateTime(date);
        photolist.setUpdateTime(date);
        photolistMapper.insert(photolist);
        return Result.ok();
    }
}
