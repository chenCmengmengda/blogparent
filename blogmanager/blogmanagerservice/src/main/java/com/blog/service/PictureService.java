package com.blog.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by 陈_C on 2018/8/7.
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile);
}
