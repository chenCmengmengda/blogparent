package com.blog.portal.controller;

import com.blog.common.pojo.ListDataResult;
import com.blog.portal.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @RequestMapping("/list")
    @ResponseBody
    public ListDataResult getPhotoList(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "8")Integer rows) {
        return photoService.getPhotoList(page,rows);

    }
}
