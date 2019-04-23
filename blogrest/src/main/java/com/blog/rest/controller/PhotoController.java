package com.blog.rest.controller;

import com.blog.common.pojo.ListDataResult;
import com.blog.rest.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @RequestMapping("/list")
    @ResponseBody
    public ListDataResult getPhotoList(Integer page, Integer rows) {
        ListDataResult result=photoService.getPhotoList(page,rows);
        return result;
    }
}
