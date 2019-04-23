package com.blog.service;

import com.blog.common.pojo.EUDataGridResult;
import com.blog.common.pojo.Result;
import com.blog.pojo.Syslog;

import java.util.List;

public interface SyslogService {
    Result addLog(Syslog syslog) throws Exception;

    EUDataGridResult getLogList(int page, int size) throws Exception;
}
