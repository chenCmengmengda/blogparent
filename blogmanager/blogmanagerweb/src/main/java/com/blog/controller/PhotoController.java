package com.blog.controller;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.TbPhotolist;
import com.blog.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @RequestMapping("/list.do")
    @ResponseBody
    public EUDataGridResult getPhotoList(Integer page, Integer rows){
        return photoService.getPhotoList(page,rows);
    }

    @RequestMapping("/add.do")
    @ResponseBody
    public Result addPhoto(@RequestBody TbPhotolist photolist){
   //     System.out.println(photolist.getImages());
        return photoService.addPhoto(photolist);
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public Result deletePhoto(Long[] ids){

        return photoService.deletePhoto(ids);
    }

}
