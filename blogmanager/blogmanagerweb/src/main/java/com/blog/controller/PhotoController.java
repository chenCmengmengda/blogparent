package com.blog.controller;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbPhotolist;
import com.blog.service.PhotoService;
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
    EUDataGridResult photoList(int page, int rows){
        return photoService.photoList(page,rows);
    }

    @RequestMapping("/add")
    @ResponseBody
    Result photoAdd(TbPhotolist photolist){
   //     System.out.println(photolist.getImages());
        return photoService.photoAdd(photolist);
    }

}
