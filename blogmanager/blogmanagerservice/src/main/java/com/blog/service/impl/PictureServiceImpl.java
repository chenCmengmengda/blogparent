package com.blog.service.impl;

/**
 * Created by 陈_C on 2018/8/7.
 */

import com.blog.common.util.FtpUtil;
import com.blog.common.util.IDUtils;
import com.blog.service.PictureService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传实现
 */
@Service
public class PictureServiceImpl implements PictureService{
    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USER_NAME}")
    private String FTP_USER_NAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;


    @Override
    public Map uploadPicture(MultipartFile uploadFile) {
        Map resultMap=new HashMap<>();


        //取文件扩展名
        String originalFilename = uploadFile.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成新文件名
        //可以使用uuid生成新文件名。
        //UUID.randomUUID()
        //可以是时间+随机数生成文件名
        String imageName = IDUtils.genImageName();
        //把图片上传到ftp服务器（图片服务器）
        //需要把ftp的参数配置到配置文件中
        //文件在服务器的存放路径，应该使用日期分隔的目录结构
        DateTime dateTime = new DateTime();
        String filePath = dateTime.toString("/yyyy/MM/dd");
        try {
            boolean result= FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD,
                    FTP_BASE_PATH, filePath, imageName + ext, uploadFile.getInputStream());
            //返回结果
            System.out.println(FTP_ADDRESS+FTP_BASE_PATH+filePath+"/"+imageName + ext+"/"+uploadFile.getName()+":"+uploadFile.getInputStream());
            System.out.println(IMAGE_BASE_URL);
            System.out.println(FTP_USER_NAME+":"+FTP_PASSWORD);
            if(!result){
                resultMap.put("error",1);
                resultMap.put("message","文件上传失败");
                return resultMap;
            }
            resultMap.put("error",0);
            resultMap.put("url",IMAGE_BASE_URL+filePath+"/"+imageName+ext);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("error",1);
            resultMap.put("message","文件发生异常");
            return resultMap;
        }
    }
}
