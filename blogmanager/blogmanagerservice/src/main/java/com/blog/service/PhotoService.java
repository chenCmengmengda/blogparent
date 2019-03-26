package com.blog.service;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbPhotolist;

public interface PhotoService {
    EUDataGridResult photoList(int page,int rows);
    Result photoAdd(TbPhotolist photolist);
}
