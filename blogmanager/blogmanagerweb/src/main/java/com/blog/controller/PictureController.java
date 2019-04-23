package com.blog.controller;

import com.blog.common.util.JsonUtils;
import com.blog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by 陈_C on 2018/8/7.
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload.do")
    @ResponseBody
    public String upload(MultipartFile uploadFile) {
        Map result = pictureService.uploadPicture(uploadFile);
        //为了保证兼容性，需要把result转化为json格式字符串
        String json= JsonUtils.objectToJson(result);
        System.out.println(json);
        return json;
    }
}
