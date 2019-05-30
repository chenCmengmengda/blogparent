package com.blog.service;

import com.blog.common.pojo.Result;
import com.blog.pojo.TbSysParameter;

public interface SysParameterService {
    Result  getSysParameter();
    Result editSysParameter(TbSysParameter sysParameter);
}

