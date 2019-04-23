package com.blog.portal.service;

import com.blog.common.pojo.ListDataResult;

public interface PhotoService {
    ListDataResult getPhotoList(Integer page, Integer rows);
}
