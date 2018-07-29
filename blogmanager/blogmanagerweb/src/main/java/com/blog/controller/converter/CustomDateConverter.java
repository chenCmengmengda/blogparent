package com.blog.controller.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 陈_C on 2018/7/29.
 */
public class CustomDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String source){
        //实现日期串转成日期类型(格式:yyyy-MM-dd HH:mm:ss)
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            //转换成功，直接返回
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //如果绑定失败，返回null
        return null;
    }
}
