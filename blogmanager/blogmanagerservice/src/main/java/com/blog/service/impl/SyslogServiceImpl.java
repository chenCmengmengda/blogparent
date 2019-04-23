package com.blog.service.impl;


import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.common.util.IDUtils;
import com.blog.mapper.SyslogMapper;
import com.blog.pojo.Syslog;
import com.blog.pojo.SyslogExample;
import com.blog.service.SyslogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SyslogServiceImpl implements SyslogService {

    @Autowired
    SyslogMapper syslogMapper;

    /**
     *
     * 添加日志
     * @param syslog
     * @return
     * @throws Exception
     */
    @Override
    public Result addLog(Syslog syslog) throws Exception {
        syslog.setId(IDUtils.genItemId());
        syslogMapper.insert(syslog);
        return Result.ok();
    }

    @Override
    public EUDataGridResult getLogList(int page, int rows) throws Exception {
        SyslogExample example=new SyslogExample();
        //分页处理
        PageHelper.startPage(page,rows);
        List<Syslog> list=syslogMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result=new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Syslog> pageInfo=new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
