package com.blog.service;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbPhotolist;

public interface PhotoService {
    EUDataGridResult getPhotoList(int page,int rows);
    Result addPhoto(TbPhotolist photolist);
}
